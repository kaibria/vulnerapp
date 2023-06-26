package ch.bbw.m183.vulnerapp.service;

import ch.bbw.m183.vulnerapp.datamodel.UserEntity;
import ch.bbw.m183.vulnerapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
@Transactional
public class UserDetailsService {
    @Autowired
    UserRepository userRepository;


    public UserEntity findbyUsername(String name){
       return userRepository.findById(name).orElseThrow();
    }

    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

}
