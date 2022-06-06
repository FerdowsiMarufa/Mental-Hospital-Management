package bd.edu.seu;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DoctorController implements Initializable {
    @FXML TableView<Patient> patientTableView;
    @FXML private TableColumn<Patient,String> nameCol;
    @FXML private TableColumn<Patient,String> illnessCol;
    @FXML private TableColumn<Patient,String> genderCol;
    @FXML private TableColumn<Patient,String> bloodGroupCol;
    @FXML private TableColumn<Patient,String> roomCol;
    //@FXML private TableColumn<Patient,String> statusCol;
    DBActions dbActions;
    private ObservableList<Patient> patients;
    public DoctorController() {
        patientTableView = new TableView<>();
        nameCol = new TableColumn<>();
        illnessCol = new TableColumn<>();
        genderCol = new TableColumn<>();
        bloodGroupCol = new TableColumn<>();
        roomCol = new TableColumn<>();
       // statusCol = new TableColumn<>();
        dbActions = new DBActions();
        patients = FXCollections.observableArrayList();
    }
    @FXML private void handleHomeAction() throws IOException {
        App.setRoot("homepage");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String id = App.getId();
       // nameCol.setCellValueFactory( new PropertyValueFactory<>("fName"));
        nameCol.setCellValueFactory( new PropertyValueFactory<>("firstName"));
        illnessCol.setCellValueFactory( new PropertyValueFactory<>("illness"));
        genderCol.setCellValueFactory( new PropertyValueFactory<>("gender"));
        bloodGroupCol.setCellValueFactory( new PropertyValueFactory<>("bloodgroup"));
        roomCol.setCellValueFactory( new PropertyValueFactory<>("room"));
        patients.addAll(dbActions.DocPatinfo(id));
        System.out.println(patients);
        patientTableView.setItems(patients);
        //App.setId(null);
    }
}
