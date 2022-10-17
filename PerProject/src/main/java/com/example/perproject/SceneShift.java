package com.example.perproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SceneShift {
    @FXML
    private Label NextScene;
    public void changeScene14() {
        try {
            Parent nextScene
                    = FXMLLoader.load(getClass().getResource("Clock.fxml"));
            Scene scene = new Scene(nextScene);
            Stage primaryStage = (Stage) NextScene.getScene().getWindow();
            primaryStage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
