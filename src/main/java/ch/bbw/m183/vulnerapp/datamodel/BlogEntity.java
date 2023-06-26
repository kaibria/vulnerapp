package ch.bbw.m183.vulnerapp.datamodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

// ...

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "blogs")
public class BlogEntity {
	@Id
	UUID id;

	@Column
	@CreationTimestamp
	LocalDateTime createdAt;

	@NotNull(message = "Der Titel darf nicht leer sein")
	@Size(min = 5, max = 100, message = "Der Titel muss zwischen 5 bis 100 Zeichen sein")
	@Column(columnDefinition = "text")
	String title;

	@NotNull(message = "Der Inhalt darf nicht leer sein")
	@Size(min = 10, message = "Der Inhalt muss mindestens 10 Zeichen erhalten")
	@Column(columnDefinition = "text")
	String body;
}
