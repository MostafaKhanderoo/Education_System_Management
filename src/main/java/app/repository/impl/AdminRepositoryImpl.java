package app.repository.impl;

import app.entity.Admin;
import app.repository.AdminRepository;
import org.hibernate.Session;

import java.util.List;

public class AdminRepositoryImpl implements AdminRepository {
    @Override
    public Admin save(Session session, Admin admin) {
        System.out.println("is okkk");
        session.persist(admin);
        return admin;

    }

    @Override
    public void delete(Session session, Long id) {
       session.remove(id);
    }

    @Override
    public List<Admin> findAdmin(Session session) {
        return null;
    }
}
