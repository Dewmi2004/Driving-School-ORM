package lk.ijse.drivingschoolorm.DAO;


import lk.ijse.drivingschoolorm.DAO.custom.impl.StudentDAOImpl;

public class DAOFactory {
    private static DAOFactory instance;
    public static DAOFactory getInstance(){
        if(instance==null){
            instance=new DAOFactory();

        }
        return instance;
    }
    private DAOFactory(){

    }
    public enum DAOtypes{
        STUDENT
    }
    public SuperDao getDAO(DAOtypes dao){
        switch(dao){
            case STUDENT:
              return new StudentDAOImpl();

              default:
                  return null;
        }
    }
}
