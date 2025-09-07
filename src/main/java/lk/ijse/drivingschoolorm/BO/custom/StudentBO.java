package lk.ijse.drivingschoolorm.BO.custom;

import lk.ijse.drivingschoolorm.BO.SuperBO;
import lk.ijse.drivingschoolorm.model.StudentDTO;

import java.util.ArrayList;

public interface StudentBO extends SuperBO {
    boolean saveStudent(StudentDTO dto) throws Exception;
    boolean updateStudent(StudentDTO dto) throws Exception;
    boolean deleteStudent(String id) throws Exception;
    ArrayList<StudentDTO> getAllStudents() throws Exception;
    String getNextStudentId() throws Exception;
}
