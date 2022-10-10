package com.example.perproject;

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
            pop.setTitle("팝업 띄우기");
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
}
