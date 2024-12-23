package app.base;

import jakarta.persistence.Id;

import java.io.Serializable;

public class BaseEntity<ID extends Serializable> {
    private ID id;
}
