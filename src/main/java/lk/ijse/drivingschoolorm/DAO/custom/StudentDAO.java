package lk.ijse.drivingschoolorm.DAO.custom;

import lk.ijse.drivingschoolorm.DAO.CrudDao;
import lk.ijse.drivingschoolorm.entity.Student;
import org.hibernate.Session;

import java.util.List;

public interface StudentDAO extends CrudDao<Student , String> {
    List<Student> search(String text, Session session);
}
