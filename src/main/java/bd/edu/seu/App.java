package bd.edu.seu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.stage.Stage.*;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static  String id;

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        App.id = id;
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("WELCOME to CIRCLE Mental Hospital");
        scene = new Scene(loadFXML("homepage"));
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}