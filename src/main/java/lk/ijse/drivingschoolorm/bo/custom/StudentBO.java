package lk.ijse.drivingschoolorm.bo.custom;

import lk.ijse.drivingschoolorm.bo.SuperBO;
import lk.ijse.drivingschoolorm.model.StudentDTO;

import java.util.List;

public interface StudentBO extends SuperBO {
    boolean saveStudent(StudentDTO dto) throws Exception;
    boolean updateStudent(StudentDTO dto) throws Exception;
    boolean deleteStudent(String id) throws Exception;
    StudentDTO findById(String id) throws Exception;
    List<StudentDTO> findAll() throws Exception;

}
