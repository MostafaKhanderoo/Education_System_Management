package app.entity;

import app.base.BaseEntity;
import app.enumeration.Degree;
import app.enumeration.Expertise;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

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
private  String username;
@Size(min = 8, message = "password can,t  less than 8 word")
private String password;
private String phoneNumber;
private String email;
private String nationalCode;
private Expertise expertise;
private Degree degree;
private Long personnelCode;
}
