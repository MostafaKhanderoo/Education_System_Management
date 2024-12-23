package app.repository;

import app.entity.Admin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public interface AdminRepository {
    Admin save(Session session, Admin admin);
    void delete(Session session ,Long id);
    List<Admin> findAdmin(Session session);
}
