package lk.ijse.drivingschoolorm.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import lk.ijse.drivingschoolorm.BO.custom.StudentBO;
import lk.ijse.drivingschoolorm.BO.custom.impl.BOFactory;
import lk.ijse.drivingschoolorm.view.tdm.StudentTM;

public class StudentPageController {

    private final StudentBO studentBO = (StudentBO) BOFactory.getInstance().getBO(BOFactory.BOtypes.STUDENT);

    public HBox imagehbox;
    public TextField txtStudentId;
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtPhone;
    public TextField txtAddress;
    public DatePicker dateRegistration;
    public TextField txtRegisterFee;
    public Button btnAdd;
    public TableView<StudentTM> tblStudents;
    public TableColumn<?,?> colId;
    public TableColumn<?,?> colName;
    public TableColumn<?,?> colEmail;
    public TableColumn<?,?> colPhone;
    public TableColumn<?,?> colAddress;
    public TableColumn<?,?> colDate;
    public Button btnClear;
    public Button btnDelete;
    public Button btnUpdate;

    public void handleAddStudent(ActionEvent actionEvent) {
    }

    public void handleClear(ActionEvent actionEvent) {
    }

    public void handleUpdateStudent(ActionEvent actionEvent) {
    }

    public void handleDeleteStudent(ActionEvent actionEvent) {
    }

    public void clickOnAction(MouseEvent mouseEvent) {
    }
}
