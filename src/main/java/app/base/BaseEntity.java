package app.base;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@MappedSuperclass
public class BaseEntity<ID extends Serializable> {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private ID id;
}
