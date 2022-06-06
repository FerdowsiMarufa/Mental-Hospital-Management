package bd.edu.seu;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
public class AdminController implements Initializable {
    @FXML private TextField FnameField;
    @FXML private TextField LnameField;
    @FXML private TextArea qualificationField;
    @FXML private TextArea addressField;
    @FXML private TextField emailField;
    @FXML private TextField contactField;
    @FXML private PasswordField passwordlField;
    @FXML private TextField genderField;
    @FXML private TextField bloodgroupField;
    @FXML private TextField roomField;
    @FXML private TextField job_typeField;
    @FXML private TextField specializationField;
    @FXML private TableView<Employee> employeeTableView;
    @FXML private TableColumn<Employee ,  String> idColumn;
    @FXML private TableColumn<Employee ,  String> nameColumn;
    @FXML private TableColumn<Employee ,  String> jobColumn;

    private ObservableList<Employee> employees;
    DBActions dbActions;
    public AdminController() {
        FnameField = new TextField();
        LnameField = new TextField();
        qualificationField = new TextArea();
        addressField = new TextArea();
        emailField = new TextField();
        contactField = new TextField();
        passwordlField = new PasswordField();
        genderField = new TextField();
        bloodgroupField = new TextField();
        roomField = new TextField();
        job_typeField = new TextField();
        specializationField = new TextField();
        employeeTableView = new TableView<>();
        idColumn = new TableColumn<>();
        nameColumn = new TableColumn<>();
        jobColumn = new TableColumn<>();
        dbActions = new DBActions();
        employees = FXCollections.observableArrayList();
    }
    private void  clearForm(){
        FnameField.clear();
        LnameField.clear();
        qualificationField.clear();
        addressField.clear();
        emailField.clear();
        contactField.clear();
        passwordlField.clear();
        genderField.clear();
        bloodgroupField.clear();
        roomField.clear();
        job_typeField.clear();
        specializationField.clear();
    }
    @FXML private void handleDoctorAction(){
        job_typeField.setText("Doctor");
    }
    @FXML private void handleReceptionistAction(){
        job_typeField.setText("Receptionist");
    }
    @FXML private void handleMaleAction(){
        genderField.setText("Male");
    }
    @FXML private void handleFemaleAction(){
        genderField.setText("Female");
    }
    @FXML private void handleOtherAction(){
        genderField.setText("Other");
    }
    @FXML private void handleApAction(){
        bloodgroupField.setText("A+");
    }
    @FXML private void handleAnAction(){
        bloodgroupField.setText("A-");
    }
    @FXML private void handleBpAction(){
        bloodgroupField.setText("B+");
    }
    @FXML private void handleBnAction(){
        bloodgroupField.setText("B-");
    }
    @FXML private void handleABpAction(){
        bloodgroupField.setText("AB+");
    }
    @FXML private void handleABnAction(){
        bloodgroupField.setText("AB-");
    }
    @FXML private void handleOpAction(){
        bloodgroupField.setText("O+");
    }
    @FXML private void handleOnAction(){
        bloodgroupField.setText("O-");
    }
    @FXML
    private void handleSaveAction(){

        String fname = FnameField.getText();
        String lname =LnameField.getText();
        String qualification = qualificationField.getText();
        String address = addressField.getText();
        String email = emailField.getText();
        String contact = contactField.getText();
        String password = passwordlField.getText();
        String gender = genderField.getText();
        String bloodgroup =bloodgroupField.getText();
        String room =roomField.getText();
        String job_type =job_typeField.getText();
        String specialization =specializationField.getText();

        Employee employee = new Employee(fname,lname,qualification,address,email,contact,password,gender,bloodgroup,room,job_type,specialization,"");
        //employees.add(employee);
         System.out.println(employee);
        dbActions.insertToEmployees(employee);
       // clearForm();
        try {
            App.setRoot("admin");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML private void handleHomeAction() throws IOException {
        App.setRoot("homepage");
    }
    @FXML private void handleCancelAction() throws IOException {
        clearForm();
    }
    @FXML
    private void handleSelectAction() {
        Employee selectedItem = employeeTableView.getSelectionModel().getSelectedItem();
        showToForm(selectedItem);
    }

    private void showToForm(Employee employee) {
        FnameField.setText(employee.getFirstName());
        LnameField.setText(employee.getLastName());
        qualificationField.setText(employee.getQualification());
        specializationField.setText(employee.getSpecialization());
        addressField.setText(employee.getAddress());
        emailField.setText(employee.getEmail());
        contactField.setText(employee.getContact());
        genderField.setText(employee.getGender());
        bloodgroupField.setText(employee.getBloodgroup());
        job_typeField.setText(employee.getJob_type());

    }

     @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       nameColumn.setCellValueFactory( new PropertyValueFactory<>("firstName"));
        idColumn.setCellValueFactory( new PropertyValueFactory<>("id"));
        jobColumn.setCellValueFactory( new PropertyValueFactory<>("job_type"));
        employees.addAll(dbActions.EMPinfo());
        System.out.println(employees);
        employeeTableView.setItems(employees);
    }
}
