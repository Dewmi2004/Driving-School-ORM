package lk.ijse.drivingschoolorm.BO.custom;

import lk.ijse.drivingschoolorm.BO.SuperBO;
import lk.ijse.drivingschoolorm.exceptions.DuplicateException;
import lk.ijse.drivingschoolorm.exceptions.InUseException;
import lk.ijse.drivingschoolorm.model.StudentDTO;

import java.util.ArrayList;
import java.util.List;

public interface StudentBO extends SuperBO {
    List<StudentDTO> getAllStudent();

    List<StudentDTO> searchBookByText(String text);

    StudentDTO getStudentById(String studentId);

    boolean saveStudent(StudentDTO studentDTO) throws DuplicateException;

    boolean updateStudent(StudentDTO studentDTO);

    boolean deleteStudent(StudentDTO studentDTO) throws InUseException;
}
