package app.entity;

import app.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
@ToString
@EqualsAndHashCode(callSuper = true)
public class Student extends BaseEntity<Long> {

    @Column(nullable = false)
    @Size(max = 30)
    private String firstname;
    @Column(nullable = false)
    @Size(max = 30)
    private String lastname;
    @Column(nullable = false ,unique = true)
@UniqueElements(message = "this username is not available")
    private String username;

    @Column(nullable = false)
    @Size(min = 8)
    private String password;
    @Column(nullable = false,unique = true)
    @Size(min = 10,max = 11)

    private String phoneNumber;
    @Column(unique = true)
    @Email(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    private String email;


    @Column(nullable = false ,length = 10,unique = true)
    @Size(min = 10)
    private String nationalCode;
    @Column(nullable = false,unique = true)
    private Long studentNumber;


    @OneToMany (mappedBy = "student")
    List<StudentLesson>studentLessons;
}
