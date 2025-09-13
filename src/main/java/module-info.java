module lk.ijse.drivingschoolorm {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires static lombok;
    requires jakarta.persistence;
    requires java.mail;


    opens lk.ijse.drivingschoolorm to javafx.fxml;
    exports lk.ijse.drivingschoolorm;
    exports lk.ijse.drivingschoolorm.config;
    opens lk.ijse.drivingschoolorm.config to javafx.fxml;
}