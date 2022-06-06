package bd.edu.seu;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class HomePageController {
    DBActions dbActions;
    //@FXML private MenuButton loginMenuButton;
    @FXML
    TextField idField;
    @FXML
    PasswordField passwordField;
    public HomePageController() {
        idField = new TextField();

        passwordField = new PasswordField();
        dbActions = new DBActions();
    }
    @FXML private void AdminLoginAction() throws IOException {
        String id = idField.getText();
        String pass = passwordField.getText();
        boolean status = dbActions.LoginAdmin(id,pass);
        System.out.println(id);
      //  System.out.println(pass);
       System.out.println(status);
       if(status){
           App.setRoot("admin");
       }
       else {
           System.out.println("Admin nai!!");
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Error Dialog");
           alert.setHeaderText("Oops, Login Failed!");
           alert.setContentText("Fill ID and Password correctly.");

           alert.showAndWait();
       }
    }
    @FXML private void RECLoginAction() throws IOException {
        String id = idField.getText();
        String pass = passwordField.getText();
        boolean status = dbActions.RECLogin(id,pass);
        System.out.println(id);
        //  System.out.println(pass);
        System.out.println(status);
        if(status){
            App.setRoot("patient");
        }
        else {
            System.out.println("receptionist nai!!");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Oops, Login Failed!");
            alert.setContentText("Fill ID and Password correctly.");

            alert.showAndWait();
        }
    }
    @FXML private void DOCLoginAction() throws IOException {
        String id = idField.getText();
        String pass = passwordField.getText();
       // boolean status = dbActions.LoginEMP(id,pass);
        boolean status = dbActions.DocLogin(id,pass);
        System.out.println(id);
        //  System.out.println(pass);
        System.out.println(status);
        if(status){
            App.setId(id);
            App.setRoot("doctor");
        }
        else {
            System.out.println("doctor nai!!");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Oops, Login Failed!");
            alert.setContentText("Fill ID and Password correctly.");

            alert.showAndWait();
        }
    }
}
