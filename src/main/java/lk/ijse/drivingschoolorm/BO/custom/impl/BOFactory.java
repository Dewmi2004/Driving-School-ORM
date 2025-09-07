package lk.ijse.drivingschoolorm.BO.custom.impl;

import lk.ijse.drivingschoolorm.BO.SuperBO;


public class BOFactory {
        private static lk.ijse.drivingschoolorm.BO.custom.impl.BOFactory instance;
        public static lk.ijse.drivingschoolorm.BO.custom.impl.BOFactory getInstance(){
            if(instance==null){
                instance=new lk.ijse.drivingschoolorm.BO.custom.impl.BOFactory();

            }
            return instance;
        }
        private BOFactory(){

        }
        public enum BOtypes{
            STUDENT
        }
        public SuperBO getBO(BOFactory.BOtypes bo){
            switch(bo){
                case STUDENT:
                    return new StudentBOImpl();

                default:
                    return null;
            }
        }
    }


