package Jarir_Bin_Rakib;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import oop.practice.tiboopproject.HelloApplication;

import java.io.IOException;

public class DashBoardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }


    @javafx.fxml.FXML
    public void goal1(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void goal2(ActionEvent actionEvent) {
    }


    @javafx.fxml.FXML
    public void goal3(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void changeViewinSameWindow(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void changeViewinDifferentWindow(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("campaign_coordinator_my_campaigns.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage astage=new Stage();
            astage.setTitle("TIB Simulator");
            astage.setScene(scene);
            astage.show();

    }
        catch (Exception e){
            //
        }
    }

}