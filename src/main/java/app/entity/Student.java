package app.entity;

import app.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student extends BaseEntity<Long> {

    private  String firstname;
    private String lastname;
    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    private String nationalCode;
    private String studentNumber;
}
