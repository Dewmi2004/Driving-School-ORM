package lk.ijse.drivingschoolorm.BO.custom.impl;

import lk.ijse.drivingschoolorm.BO.custom.StudentBO;
import lk.ijse.drivingschoolorm.DAO.DAOFactory;
import lk.ijse.drivingschoolorm.DAO.custom.StudentDAO;
import lk.ijse.drivingschoolorm.model.StudentDTO;

import java.util.ArrayList;

public class StudentBOImpl implements StudentBO {
    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOtypes.STUDENT);
    @Override
    public boolean saveStudent(StudentDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean updateStudent(StudentDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean deleteStudent(String id) throws Exception {
        return false;
    }

    @Override
    public ArrayList<StudentDTO> getAllStudents() throws Exception {
        return null;
    }

    @Override
    public String getNextStudentId() throws Exception {
        return "";
    }
}
