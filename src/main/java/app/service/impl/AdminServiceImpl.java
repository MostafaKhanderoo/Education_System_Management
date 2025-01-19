package app.service.impl;

import app.cfg.SessionFactoryInstance;
import app.entity.Admin;
import app.repository.AdminRepository;
import app.repository.impl.AdminRepositoryImpl;
import app.service.AdminService;
import app.service.Authentication.AuthenticationAdmin;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;

import java.util.List;

@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepositoryImpl adminRepository;

    @Override
    public Admin save(Admin admin) {
        try (var session = SessionFactoryInstance.sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                adminRepository.save(session, admin);
                session.getTransaction().commit();
                System.out.println("is ok");
                return admin;
            } catch (Exception e) {
                System.out.println("error");
                session.getTransaction().rollback();
                throw new RuntimeException(e.getMessage());


            }
        }
    }

    @Override
    public void delete(Long id) {
        try (var session = SessionFactoryInstance.sessionFactory.openSession()) {
            adminRepository.delete(session, id);
        }
    }

    @Override
    public List<Admin> selectAllAdmin() {
        try (var session = SessionFactoryInstance.sessionFactory.openSession()) {
            return adminRepository.selectAllAdmin(session);
        }
    }

    @Override
    public Admin findByUsername(String username) {
        try (var session = SessionFactoryInstance.sessionFactory.openSession()) {
            return adminRepository.findByUsername(session, username);
        }
    }

    public Admin login(String username, String password) {
try(var session =SessionFactoryInstance.sessionFactory.openSession()){
    return  adminRepository.login(session,username,password);
}
    }
}
