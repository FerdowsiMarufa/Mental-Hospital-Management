package bd.edu.seu;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.time.LocalDate;
import java.io.IOException;

public class ReleaseController {
    @FXML
    private TextField idField;
    @FXML private DatePicker releaseddateField;
    DBActions dbActions;
    public ReleaseController() {
        idField = new TextField();
       releaseddateField = new DatePicker();
        dbActions = new DBActions();
    }
    private void  clearForm(){
       idField.clear();
       releaseddateField.setValue(null);
    }
    @FXML private void handleReleaseAction() throws IOException {
        int id = Integer.parseInt(idField.getText());
        LocalDate date = releaseddateField.getValue();
        dbActions.releasePat(id,date);
        clearForm();
    }
    @FXML private void handleBackAction() throws IOException {
        App.setRoot("patient");
    }
    @FXML private void handleCancelAction() throws IOException {
        clearForm();
    }
}
