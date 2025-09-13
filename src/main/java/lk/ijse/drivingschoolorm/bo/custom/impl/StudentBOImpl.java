package lk.ijse.drivingschoolorm.bo.custom.impl;

import lk.ijse.drivingschoolorm.bo.custom.StudentBO;
import lk.ijse.drivingschoolorm.dao.DAOFactory;
import lk.ijse.drivingschoolorm.dao.custom.StudentDAO;
import lk.ijse.drivingschoolorm.entity.Student;
import lk.ijse.drivingschoolorm.model.StudentDTO;

import java.util.List;
import java.util.stream.Collectors;


public class StudentBOImpl implements StudentBO {
    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOtypes.STUDENT);

    @Override
    public boolean saveStudent(StudentDTO dto) throws Exception {
        Student student = new Student(
                dto.getStudentName(),
                dto.getStudentEmail(),
                dto.getStudentPhone(),
                dto.getStudentAddress(),
                dto.getRegisterFee(),
                dto.getRegisterDate()
        );
        return studentDAO.save(student);
    }

    @Override
    public boolean updateStudent(StudentDTO dto) throws Exception {
        Student student = new Student(
                dto.getStudentID(),
                dto.getStudentName(),
                dto.getStudentEmail(),
                dto.getStudentPhone(),
                dto.getStudentAddress(),
                dto.getRegisterFee(),
                dto.getRegisterDate()
        );
        return studentDAO.update(student);
    }

    @Override
    public boolean deleteStudent(String id) throws Exception {
        return studentDAO.delete(id);
    }

    @Override
    public StudentDTO findById(String id) throws Exception {
        Student student = studentDAO.findById(id);
        if (student == null) return null;
        return new StudentDTO(
                student.getStudentID(),
                student.getStudentName(),
                student.getStudentEmail(),
                student.getStudentPhone(),
                student.getStudentAddress(),
                student.getRegisterFee(),
                student.getRegisterDate()
        );
    }

    @Override
    public List<StudentDTO> findAll() throws Exception {
        return studentDAO.findAll().stream().map(student ->
                new StudentDTO(
                        student.getStudentID(),
                        student.getStudentName(),
                        student.getStudentEmail(),
                        student.getStudentPhone(),
                        student.getStudentAddress(),
                        student.getRegisterFee(),
                        student.getRegisterDate()
                )).collect(Collectors.toList());
    }
}

