package app.entity;

import app.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "admins")
public class Admin extends BaseEntity<Long> {
    @Column(name = "admin_name")
    private String adminName;


    @Column(name = "admin_username" ,nullable = false   ,unique = true)
    private String username;
    @Column(name = "admin_password",unique = false)
    private String password;
}
