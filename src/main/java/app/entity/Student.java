package app.entity;

import app.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

@Column(nullable = false)
    private  String firstname;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String phoneNumber;
    @Column
    private String email;
    @Column(nullable = false)
    private String nationalCode;
    @Column(nullable = false)
    private Long studentNumber;
}
