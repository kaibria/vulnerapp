package ch.bbw.m183.vulnerapp.provider;

import ch.bbw.m183.vulnerapp.datamodel.UserEntity;
import ch.bbw.m183.vulnerapp.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private static final int MAX_ATTEMPTS = 5;
    @Autowired
    UserDetailsService userService;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserEntity user = userService.findbyUsername(name);

        if (user != null) {

            if (user.getFailedAttempts() >= MAX_ATTEMPTS) {
                throw new LockedException("User ist gesperrt wegen zu vielen Versuche");
            }
            if (new BCryptPasswordEncoder().matches(password, user.getPassword())) {
                List<GrantedAuthority> authorities = user.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority(role.getRole()))
                        .collect(Collectors.toList());
                user.setFailedAttempts(0);
                userService.save(user);

                return new UsernamePasswordAuthenticationToken(
                        name, password, authorities);
            } else {
                user.setFailedAttempts(user.getFailedAttempts() + 1);
                userService.save(user);
            }
        }

        throw new BadCredentialsException("Invalid username or password");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
