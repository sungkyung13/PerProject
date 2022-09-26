package com.example.perproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable{


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private Button changeBtn;
    public void changeScene() {
        try {
            Parent nextScene
                    = FXMLLoader.load(getClass().getResource("Main.fxml"));
            Scene scene = new Scene(nextScene);
            Stage primaryStage = (Stage) changeBtn.getScene().getWindow();
            primaryStage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Label changeBtn2;
    public void changeScene2() {
        try {
            Parent nextScene
                    = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
            Scene scene = new Scene(nextScene);
            Stage primaryStage = (Stage) changeBtn2.getScene().getWindow();
            primaryStage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
