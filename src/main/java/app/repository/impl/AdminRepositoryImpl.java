package app.repository.impl;

import app.entity.Admin;
import app.repository.AdminRepository;
import org.hibernate.Session;

import java.util.List;

public class AdminRepositoryImpl implements AdminRepository {
    @Override
    public Admin save(Session session, Admin admin) {
        session.persist(admin);
        return admin;

    }

    @Override
    public void delete(Session session, Long id) {
       session.createMutationQuery("delete from Admin a where a.id =:id").setParameter("id",id).executeUpdate();
    }

    @Override
    public List<Admin> selectAllAdmin(Session session) {
        return session.createQuery("from Admin",Admin.class).list();
    }
}
