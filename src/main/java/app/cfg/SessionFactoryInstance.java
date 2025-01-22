package app.cfg;

import app.entity.*;
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
        .addAnnotatedClass(Lesson.class)
        .addAnnotatedClass(StudentLesson.class)
        .buildSessionFactory();

    }
}
