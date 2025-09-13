package lk.ijse.drivingschoolorm.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import lk.ijse.drivingschoolorm.bo.custom.StudentBO;
import lk.ijse.drivingschoolorm.bo.custom.impl.BOFactory;
import lk.ijse.drivingschoolorm.model.StudentDTO;
import lk.ijse.drivingschoolorm.view.tdm.StudentTM;

import java.sql.Date;
import java.util.List;

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

    public void initialize() {
        colId.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("studentID"));
        colName.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("studentName"));
        colEmail.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("studentEmail"));
        colPhone.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("studentPhone"));
        colAddress.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("studentAddress"));
        colDate.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("registerDate"));

        loadAllStudents();
    }

    private void loadAllStudents() {
        try {
            List<StudentDTO> all = studentBO.findAll();
            ObservableList<StudentTM> list = FXCollections.observableArrayList();
            for (StudentDTO dto : all) {
                list.add(new StudentTM(
                        dto.getStudentID(),
                        dto.getStudentName(),
                        dto.getStudentEmail(),
                        dto.getStudentPhone(),
                        dto.getStudentAddress(),
                        dto.getRegisterFee(),
                        dto.getRegisterDate()
                ));
            }
            tblStudents.setItems(list);
        } catch (Exception e) {
            showError("Error loading students: " + e.getMessage());
        }
    }
    public void handleAddStudent(ActionEvent actionEvent) {
        try {
            StudentDTO dto = new StudentDTO(
                    txtStudentId.getText(),
                    txtName.getText(),
                    txtEmail.getText(),
                    txtPhone.getText(),
                    txtAddress.getText(),
                    txtRegisterFee.getText(),
                    Date.valueOf(dateRegistration.getValue())
            );
            if (studentBO.saveStudent(dto)) {
                showInfo("Student added successfully!");
                loadAllStudents();
                clearFields();
            }
        } catch (Exception e) {
            showError("Error saving student: " + e.getMessage());
        }
    }

    public void handleClear(ActionEvent actionEvent) {
        clearFields();
    }
    private void clearFields() {
        txtStudentId.clear();
        txtName.clear();
        txtEmail.clear();
        txtPhone.clear();
        txtAddress.clear();
        txtRegisterFee.clear();
        dateRegistration.setValue(null);
    }

    public void handleUpdateStudent(ActionEvent actionEvent) {
        try {
            StudentDTO dto = new StudentDTO(
                    txtStudentId.getText(),
                    txtName.getText(),
                    txtEmail.getText(),
                    txtPhone.getText(),
                    txtAddress.getText(),
                    txtRegisterFee.getText(),
                    Date.valueOf(dateRegistration.getValue())
            );
            if (studentBO.updateStudent(dto)) {
                showInfo("Student updated successfully!");
                loadAllStudents();
                clearFields();
            }
        } catch (Exception e) {
            showError("Error updating student: " + e.getMessage());
        }
    }

    public void handleDeleteStudent(ActionEvent actionEvent) {
        try {
            if (studentBO.deleteStudent(txtStudentId.getText())) {
                showInfo("Student deleted successfully!");
                loadAllStudents();
                clearFields();
            }
        } catch (Exception e) {
            showError("Error deleting student: " + e.getMessage());
        }
    }
    private void showInfo(String msg) {
        new Alert(Alert.AlertType.INFORMATION, msg).show();
    }

    private void showError(String msg) {
        new Alert(Alert.AlertType.ERROR, msg).show();
    }

    public void clickOnAction(MouseEvent mouseEvent) {
        StudentTM selected = tblStudents.getSelectionModel().getSelectedItem();
        if (selected != null) {
            txtStudentId.setText(selected.getStudentID());
            txtName.setText(selected.getStudentName());
            txtEmail.setText(selected.getStudentEmail());
            txtPhone.setText(selected.getStudentPhone());
            txtAddress.setText(selected.getStudentAddress());
            txtRegisterFee.setText(selected.getRegisterFee());
            dateRegistration.setValue(selected.getRegisterDate().toLocalDate());
        }
    }
}
