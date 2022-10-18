package com.example.perproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Login implements Initializable{


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private TextField LoginId;
    @FXML
    private PasswordField LoginPw;
    @FXML
    private Button LoginBtn;

    String ID;
    String PW;

    // 입력 확인
    public void Login() {
        if (LoginId.getText().isEmpty() && LoginPw.getText().isEmpty()) {
            alert("아이디와 비밀번호를 입력해 주세요.");
        } else if (LoginId.getText().isEmpty()) {
            alert("아이디를 입력해 주세요.");
        } else if (LoginPw.getText().isEmpty()) {
            alert("비밀번호를 입력해 주세요.");
        } else  {
            changeToMain();
        }
    }

    public void alert(String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("!");
        alert.setContentText(text);
        alert.show();
    }

    public void changeToMain() {
        String getID = LoginId.getText();
        String getPW = LoginPw.getText();
        DBUtil db = new DBUtil();
        Connection con = db.getConnection();

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from information where id = '" + getID + "'";

        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                String dataID = rs.getString("id");
                String dataPW = rs.getString("password");

                ID = dataID;
                PW = dataPW;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        if(getID.equals(ID)) {
            if(getPW.equals(PW)) {
                try {
                    Parent login = FXMLLoader.load(getClass().getResource("/view/MainLayOut.fxml"));
                    Scene scene = new Scene(login);
                    Stage primaryStage = (Stage) changeMain.getScene().getWindow();
                    primaryStage.setScene(scene);
                    scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                alert("비밀번호를 다시 입력해주세요.");
            }
        }else {
            alert("아이디를 다시 입력해주세요.");
        }

    }





// sigh-up 화면으로 이동하는 라벨
    @FXML
    private Label SingUpBtn;
    public void changeScene2() {
        try {
            Parent nextScene
                    = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
            Scene scene = new Scene(nextScene);
            Stage primaryStage = (Stage) SingUpBtn.getScene().getWindow();
            primaryStage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
