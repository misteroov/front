package mainPage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Controller;
import sample.Main;

import java.io.IOException;

public class MainPage {
public static int countRUB=0;
    @FXML
    private TextField count;

    @FXML
    void countAction(ActionEvent event) {
        countRUB= Integer.parseInt(count.getText());

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/sample.fxml"));
            Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(root, 800, 460));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}