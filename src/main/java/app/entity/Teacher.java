package app.entity;

import app.Main;
import app.base.BaseEntity;
import app.enumeration.Degree;
import app.enumeration.Expertise;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teachers")

public class Teacher extends BaseEntity<Long> {

private String firstname;
private String lastname;
@Column(unique = true)
private  String username;
@Size(min = 8, message = "password can,t  less than 8 word")
private String password;
    @Column(unique = true)
    @Size(min = 10,max = 11)
private String phoneNumber;
    @Column(unique = true)
    @Email(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")

    private String email;
    @Column(unique = true)
    @Size(min = 10,max = 10)
private String nationalCode;
    @Enumerated(EnumType.STRING)
private Expertise expertise;
    @Enumerated(EnumType.STRING)
private Degree degree;
    @Column(unique = true)
    @Size(min = 5)
private Long personnelCode;
}
