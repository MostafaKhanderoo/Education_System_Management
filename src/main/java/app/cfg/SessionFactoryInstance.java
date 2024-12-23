package app.cfg;

import app.entity.Admin;
import app.entity.Student;
import app.entity.Teacher;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryInstance {
    public static SessionFactory sessionFactory;

    static {
sessionFactory = new Configuration()
        .configure()
        .addAnnotatedClass(Admin.class)
        .addAnnotatedClass(Student.class)
        .addAnnotatedClass(Teacher.class)
        .buildSessionFactory();

    }
}
