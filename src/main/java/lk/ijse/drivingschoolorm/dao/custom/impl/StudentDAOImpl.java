package lk.ijse.drivingschoolorm.dao.custom.impl;

import lk.ijse.drivingschoolorm.config.FactoryConfiguration;
import lk.ijse.drivingschoolorm.dao.custom.StudentDAO;
import lk.ijse.drivingschoolorm.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    private final FactoryConfiguration factoryConfiguration = FactoryConfiguration.getInstance();

    @Override
    public boolean save(Student entity) throws Exception {
        Session session = factoryConfiguration.getSession();
        Transaction tx = session.beginTransaction();
        session.persist(entity);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Student entity) throws Exception {
        Session session = factoryConfiguration.getSession();
        Transaction tx = session.beginTransaction();
        session.merge(entity);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) throws Exception {
        Session session = factoryConfiguration.getSession();
        Transaction tx = session.beginTransaction();
        Student student = session.get(Student.class, s);
        if (student != null) {
            session.remove(student);
        }
        tx.commit();
        session.close();
        return student != null;
    }

    @Override
    public Student findById(String s) throws Exception {
        Session session = factoryConfiguration.getSession();
        Student student = session.get(Student.class, s);
        session.close();
        return student;
    }

    @Override
    public List<Student> findAll() throws Exception {
        Session session = factoryConfiguration.getSession();
        List<Student> list = session.createQuery("FROM Student", Student.class).list();
        session.close();
        return list;
    }
}
