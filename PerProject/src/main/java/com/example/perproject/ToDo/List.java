package com.example.perproject.ToDo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class List implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private Button PopBtn;
    @FXML
    private Label label;
    @FXML
    private Button CancelBtn;
    private Stage pop;
    public void popup() {
        Stage mainStage = (Stage) PopBtn.getScene().getWindow();

        pop = new Stage(StageStyle.DECORATED);
        pop.initModality(Modality.WINDOW_MODAL);
        pop.initOwner(mainStage);

        try {
            Parent nextScene
                    =FXMLLoader.load(getClass().getResource("AddList.fxml"));
            Scene scene = new Scene(nextScene);
            pop.setScene(scene);
            pop.setTitle("List Add");
            pop.setResizable(false);
            pop.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void close() {
        pop = (Stage) CancelBtn.getScene().getWindow();
        pop.close();
    }

 // 아래 부분 바 버튼

    @FXML
    private Button changeBt11;
    public void changeScene11() {
        try {
            Parent nextScene
                    = FXMLLoader.load(getClass().getResource("Clock.fxml"));
            Scene scene = new Scene(nextScene);
            Stage primaryStage = (Stage) changeBt11.getScene().getWindow();
            primaryStage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button changeBtn12;
    public void changeScene12() {
        try {
            Parent nextScene
                    = FXMLLoader.load(getClass().getResource("Main.fxml"));
            Scene scene = new Scene(nextScene);
            Stage primaryStage = (Stage) changeBtn12.getScene().getWindow();
            primaryStage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button changeBtn13;
    public void changeScene13() {
        try {
            Parent nextScene
                    = FXMLLoader.load(getClass().getResource("list.fxml"));
            Scene scene = new Scene(nextScene);
            Stage primaryStage = (Stage) changeBtn13.getScene().getWindow();
            primaryStage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
