package app.entity;

import app.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "admins")
public class Admin extends BaseEntity<Long> {
    @Column(name = "admin_name")
    private String adminName;
    @Column(name = "admin_username" ,nullable = false   ,unique = true)
    private String username;
    @Column(name = "admin_password",unique = false)
    private String password;
}
