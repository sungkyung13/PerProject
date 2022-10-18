package com.example.perproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

public class SignUp {

    @FXML
    private TextField id;
    @FXML
    private TextField pw;
    @FXML
    private TextField name;
    @FXML
    private Button joinBtn;

    public void insertMember() {
        DBUtil db = new DBUtil();
        Connection conn = db.getConnection();

        PreparedStatement pstmt = null;
        String sql = "INSERT INTO users(id, pw, name) VALUES(?,?,?)";

        try {
            pstmt = ((Connection) conn).prepareStatement(sql);
            pstmt.setString(1, id.getText());
            pstmt.setString(2, pw.getText());
            pstmt.setString(3, name.getText());
            pstmt.executeUpdate();
            alert("회원가입이 정상적으로 완료되었습니다.", null);


        } catch (Exception e) {
            e.printStackTrace();
            alert("회원가입이 제대로 완료되지 않았습니다.", null);

        }
    }

    public void alert(String msg, String header) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("!");
        alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.show();
    }

    //  화면 전환 버튼 구현

    @FXML
    private Label changeBtn4;
    public void changeScene4() {
        try {
            Parent nextScene
                    = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene scene = new Scene(nextScene);
            Stage primaryStage = (Stage) changeBtn4.getScene().getWindow();
            primaryStage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
