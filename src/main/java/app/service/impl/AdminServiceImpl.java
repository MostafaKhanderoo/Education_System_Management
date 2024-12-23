package app.service.impl;

import app.cfg.SessionFactoryInstance;
import app.entity.Admin;
import app.repository.AdminRepository;
import app.repository.impl.AdminRepositoryImpl;
import app.service.AdminService;
import lombok.RequiredArgsConstructor;

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
}
