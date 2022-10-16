package com.example.perproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Main implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }




    // 화면 전환 Button 구현

    @FXML
    private Button changeBtn5;
    public void changeScene5() {
        try {
            Parent nextScene
                    = FXMLLoader.load(getClass().getResource("Clock.fxml"));
            Scene scene = new Scene(nextScene);
            Stage primaryStage = (Stage) changeBtn5.getScene().getWindow();
            primaryStage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button changeBtn6;
    public void changeScene6() {
        try {
            Parent nextScene
                    = FXMLLoader.load(getClass().getResource("Main.fxml"));
            Scene scene = new Scene(nextScene);
            Stage primaryStage = (Stage) changeBtn6.getScene().getWindow();
            primaryStage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button changeBtn7;
    public void changeScene7() {
        try {
            Parent nextScene
                    = FXMLLoader.load(getClass().getResource("list.fxml"));
            Scene scene = new Scene(nextScene);
            Stage primaryStage = (Stage) changeBtn7.getScene().getWindow();
            primaryStage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
