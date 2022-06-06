package bd.edu.seu;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PatientController implements Initializable {
    @FXML private TextField FnameField;
    @FXML private TextField LnameField;
    @FXML private TextArea addressField;
    @FXML private TextArea illnessField;
    @FXML private TextField doctorIDField;
    @FXML private TextField contactField;
    @FXML private TextField genderField;
    @FXML private TextField bloodgroupField;
    @FXML private TextField roomField;
    @FXML private TableView<Patient> patientTableView;
    @FXML private TableColumn<Patient,  String> pidColumn;
    @FXML private TableColumn<Patient ,  String> pnameColumn;
    @FXML private TableColumn<Patient ,  String> pdocColumn;
    @FXML private TableColumn<Patient,String> proomCol;
    DBActions dbActions;
    private ObservableList<Patient> patients;
    @FXML private TableView<Employee> employeeTableView;
    @FXML private TableColumn<Employee ,  String> idColumn;
    @FXML private TableColumn<Employee ,  String> nameColumn;
    @FXML private TableColumn<Employee ,  String> jobColumn;
    private ObservableList<Employee> employees;

    public PatientController() {

        FnameField = new TextField();
        LnameField = new TextField();
        addressField = new TextArea();
        illnessField = new TextArea();
        doctorIDField = new TextField();
        contactField = new TextField();
        genderField = new TextField();
        bloodgroupField = new TextField();
        roomField = new TextField();

        patientTableView = new TableView<>();
        pidColumn = new TableColumn<>();
        pnameColumn = new TableColumn<>();
        pdocColumn = new TableColumn<>();
        proomCol = new TableColumn<>();
        dbActions = new DBActions();
        patients = FXCollections.observableArrayList();
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
        addressField.clear();
        illnessField.clear();
        doctorIDField.clear();
        contactField.clear();
        genderField.clear();
        bloodgroupField.clear();
        roomField.clear();

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
    private void handleAdmitAction(){

        String fname = FnameField.getText();
        String lname = LnameField.getText();
        String address = addressField.getText();
        String illness= illnessField.getText();
        String docID= doctorIDField.getText();
        String contact = contactField.getText();
        String gender = genderField.getText();
        String bloodgroup =bloodgroupField.getText();
        String room =roomField.getText();
        Patient patient = new Patient(fname,lname,address,illness,docID,contact,gender,room,bloodgroup,"","");
        System.out.println(patient);
       // patients.add(patient);
        //dbActions.CheckDoc(docID);
        if (dbActions.CheckDoc(docID)){
            dbActions.insertToPatients(patient);
        } else {
            System.out.println("Admin nai!!");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Failed!");
            alert.setContentText("Fill Doctor ID correctly.");

            alert.showAndWait();
        }

        //clearForm();
        try {
            App.setRoot("patient");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML private void handleReleaseAction() throws IOException {
        App.setRoot("release");
    }
    @FXML private void handleHomeAction() throws IOException {
        App.setRoot("homepage");
    }
    @FXML private void handleCancelAction() throws IOException {
        clearForm();
    }
    @FXML
    private void handleSelectAction() {
        Patient selectedItem = patientTableView.getSelectionModel().getSelectedItem();

        showToForm(selectedItem);
    }

    private void showToForm(Patient patient) {
        FnameField.setText(patient.getFirstName());
        LnameField.setText(patient.getLastName());
        illnessField.setText(patient.getIllness());
        addressField.setText(patient.getAddress());
        contactField.setText(patient.getContact());
        genderField.setText(patient.getGender());
        bloodgroupField.setText(patient.getBloodgroup());
        roomField.setText(patient.getRoom());
        doctorIDField.setText(patient.getDocID());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pnameColumn.setCellValueFactory( new PropertyValueFactory<>("firstName"));
        pidColumn.setCellValueFactory( new PropertyValueFactory<>("id"));
        pdocColumn.setCellValueFactory( new PropertyValueFactory<>("docID"));
        proomCol.setCellValueFactory( new PropertyValueFactory<>("room"));
        patients.addAll(dbActions.RecPatinfo());
        System.out.println(patients);
        patientTableView.setItems(patients);
        nameColumn.setCellValueFactory( new PropertyValueFactory<>("firstName"));
        idColumn.setCellValueFactory( new PropertyValueFactory<>("id"));
        jobColumn.setCellValueFactory( new PropertyValueFactory<>("job_type"));
        employees.addAll(dbActions.EMPinfo());
        System.out.println(employees);
        employeeTableView.setItems(employees);
    }
}
