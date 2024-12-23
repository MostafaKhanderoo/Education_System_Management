package app.base;

import jakarta.persistence.Id;

import java.io.Serializable;

public class BaseEntity<ID extends Serializable> {
    @Id
    private ID id;
}
