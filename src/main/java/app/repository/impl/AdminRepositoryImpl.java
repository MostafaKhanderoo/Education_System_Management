package app.repository.impl;

import app.cfg.SessionFactoryInstance;
import app.entity.Admin;
import app.repository.AdminRepository;
import app.service.Authentication.AuthenticationAdmin;
import org.hibernate.Session;

import java.util.List;
import java.util.Locale;

public class AdminRepositoryImpl implements AdminRepository {
    @Override
    public Admin save(Session session, Admin admin) {
        session.persist(admin);
        return admin;

    }

    @Override
    public void delete(Session session, Long id) {
        session.createMutationQuery("delete from Admin a where a.id =:id").setParameter("id", id).executeUpdate();
    }

    @Override
    public List<Admin> selectAllAdmin(Session session) {
        List<Admin> allAdmin= session.createQuery("from Admin", Admin.class).list();
        return allAdmin;
    }

    @Override
    public Admin findByUsername(Session session, String username) {
        Admin admin = session.createQuery(" from Admin where username = :username", Admin.class).setParameter("username", username).getSingleResult();
        return admin;
    }

    @Override
    public Admin login(Session session, String username, String password) {
        var admin= findByUsername(session,username);
      try  {
          if (admin.getUsername().equals(username))
              if (admin.getPassword().equals(password)) {
                  AuthenticationAdmin.setLoggedAdmin(admin);
                  return admin;
              } else {
                  System.out.println("error");

              }
      }catch (Exception e){
          throw new RuntimeException(e.getMessage());

      }
        return null;
    }
}
