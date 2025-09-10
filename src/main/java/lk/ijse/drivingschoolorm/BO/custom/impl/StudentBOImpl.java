package lk.ijse.drivingschoolorm.BO.custom.impl;

import lk.ijse.drivingschoolorm.BO.custom.StudentBO;
import lk.ijse.drivingschoolorm.DAO.DAOFactory;
import lk.ijse.drivingschoolorm.DAO.custom.StudentDAO;
import lk.ijse.drivingschoolorm.config.FactoryConfiguration;
import lk.ijse.drivingschoolorm.exceptions.DuplicateException;
import lk.ijse.drivingschoolorm.exceptions.InUseException;
import lk.ijse.drivingschoolorm.model.StudentDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentBOImpl implements StudentBO {
    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOtypes.STUDENT);

    @Override
    public List<StudentDTO> getAllStudent() {
        Session session = FactoryConfiguration.getInstance().getSession();
        try {
            return studentDAO.findAll(session).stream().map(student -> convertor.fromStudent(student)).collect(Collectors.toList());
        }finally {
            session.close();
        }
    }

    @Override
    public List<StudentDTO> searchBookByText(String text) {
        Session session = FactoryConfiguration.getInstance().getSession();
        try {
            return studentDAO.search(text, session).stream().map(student -> convertor.fromStudent(student)).collect(Collectors.toList());
        }finally {
            session.close();
        }
    }

    @Override
    public StudentDTO getStudentById(String studentId) {
        Session session = FactoryConfiguration.getInstance().getSession();
        try {
            return convertor.fromStudent(studentDAO.findByPk(studentId, session).get());
        }finally {
            session.close();
        }
    }

    @Override
    public boolean saveStudent(StudentDTO studentDTO) throws DuplicateException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            if (studentDAO.findByPk(studentDTO.getStudentID(), session).isPresent())
                throw new DuplicateException();
            studentDAO.save(convertor.toStudent(studentDTO), session);
            transaction.commit();
            return true;
        }catch (DuplicateException e){
            throw new DuplicateException();
        }catch (Exception e){
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }


    @Override
    public boolean updateStudent(StudentDTO studentDTO) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            studentDAO.update(convertor.toStudent(studentDTO), session);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean deleteStudent(StudentDTO studentDTO) throws InUseException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            if (queryDAO.findAllUnPaidReservationDetailsByStudentId(studentDTO.getStudentID(), session).size() > 0)
                throw new InUseException();
            studentDAO.deleteByPk(studentDTO.getStudentID(), session);
            transaction.commit();
            return true;
        }catch (InUseException e){
            throw new InUseException();
        }catch (Exception e){
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }
    }

