package app.entity;

import app.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
    @Column(name = "admin_name" ,nullable = false,unique = true)
    private String username;
    @Column(name = "admin_password",unique = false)
    private String password;
}
