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
import java.sql.*;
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

    String id;
    String pw;

    // id, pw 존재하는지 데이터 베이스에서 조회
    public void changeToMain() {
        String getID = LoginId.getText();
        String getPW = LoginPw.getText();
        DBUtil db = new DBUtil();
        Connection con = db.getConnection();

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from Users WHERE id = '" + getID + "'";

        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                String dataID = rs.getString("id");
                String dataPW = rs.getString("pw");

                id = dataID;
                pw = dataPW;

            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        //id, pw TextField 입력 확인
        if(getID.equals(id)) {
            if(getPW.equals(pw)) {
                try {
                    //화면 넘김
                    Parent login = FXMLLoader.load(getClass().getResource("SceneShift.fxml"));
                    Scene scene = new Scene(login);
                    Stage primaryStage = (Stage) LoginBtn.getScene().getWindow();
                    primaryStage.setScene(scene);
                    //스타일 시트 연결
                    scene.getStylesheets().add(getClass().getResource("Design.css").toExternalForm());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                alert("비밀번호를 다시 입력해주세요.", null);
            }
        }else {
            alert("아이디를 다시 입력해주세요.", null);
        }

    }

    // 알림창 띄우기
    public void alert(String msg, String header) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("!");
        alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.show();
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

    @FXML
    private Label MainBtn;
    public void changeScene() {
        try {
            Parent nextScene
                    = FXMLLoader.load(getClass().getResource("SceneShift.fxml"));
            Scene scene = new Scene(nextScene);
            Stage primaryStage = (Stage) MainBtn.getScene().getWindow();
            primaryStage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
