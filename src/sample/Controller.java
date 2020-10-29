package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import mainPage.MainPage;

import java.io.IOException;



public class Controller {
    ObservableList<String> rasxodiLIst= FXCollections.observableArrayList(
            "Еда",
            "Бытовая химия",
            "Коммуналка",
            "Ремонт",
            "Игрушки Марку",
            "Расходы на авто",
            "Одежда"

    );
    ObservableList<String> doxodiLIst= FXCollections.observableArrayList(
            "Аванс",
            "З/п",
            "Прочее",
            "Остаток на счету"

    );
    String s="";



    @FXML
    private TextField countrasx;

    @FXML
    private TextField countdox;
    @FXML
    private Text countSUM;


    @FXML
    private Button setCountButton;
    @FXML

    void eventCountButton(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("mainPage/mainPage.fxml"));
            Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }





    @FXML
    private Label textShow;
    @FXML

    void select(ActionEvent event) {
s = mainComboBox.getSelectionModel().getSelectedItem().toString();

    }


    @FXML
    private ComboBox mainComboBox;
    public void initialize(){
        mainComboBox.setItems(rasxodiLIst);
        mainComboBoxDox.setItems(doxodiLIst);
        countSUM.setText(String.valueOf(MainPage.countRUB));

    }
    @FXML
    private ComboBox mainComboBoxDox;
    @FXML
    void selectadd(ActionEvent event) {

        s = mainComboBoxDox.getSelectionModel().getSelectedItem().toString();

    }
    //Сука не работают ДОХОДЫ!!!
    @FXML
    void dox(ActionEvent event) {
String temp = countdox.getText();
        textShow.setText(s+" + "+temp);
        MainPage.countRUB = MainPage.countRUB+Integer.parseInt(temp);
        countSUM.setText(String.valueOf(MainPage.countRUB));
    }

    @FXML
    void rasxmin(ActionEvent event) {
        String temp = countrasx.getText();
        textShow.setText(s+" - "+temp);
        MainPage.countRUB = MainPage.countRUB-Integer.parseInt(temp);
        countSUM.setText(String.valueOf(MainPage.countRUB));


    }



}
