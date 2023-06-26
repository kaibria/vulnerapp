package ch.bbw.m183.vulnerapp.datamodel;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@NotNull(message = "Benutzername darf nicht leer sein")
	@Size(min = 3, max = 30, message = "Benutzername muss zwischen 3 und 30 Zeichen lang sein")
	String username;

	@Column
	@NotNull(message = "Vollständiger Name darf nicht leer sein")
	@Size(min = 5, max = 100, message = "Vollständiger Name muss zwischen 5 und 100 Zeichen lang sein")
	String fullname;

	@Column
	@NotNull(message = "Passwort darf nicht null sein")
	@Size(min = 8, message = "Passwort muss mindestens 8 Zeichen lang sein")
	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}",
			message = "Passwort muss mindestens eine Zahl, ein kleinbuchstabe, ein Grossbuchstabe und ein Sonderzeichen")
	String password;

	@Column
	int failedAttempts;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	Set<RoleEntity> roles;
}
