package com.example.perproject;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TimeController implements Initializable{

	@FXML private Button newBtn;
	@FXML private Button pauseBtn;
	@FXML private Button reStartBtn;
	@FXML private Button clearBtn;
	@FXML private Label timeLabel;
	private int hours;
	private int minutes;
	private int seconds;
	private Boolean isStart = false;
	private Timeline timeLine;
	private Duration time = Duration.ZERO;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		timeLine = new Timeline();
		timeLine.setCycleCount(Timeline.INDEFINITE);
		timeLine.play();

	}

	public void newButton(ActionEvent event){
		timeLine.pause();
		time = Duration.ZERO;
		isStart = true;
		if(isStart == true){

			KeyFrame kf = new KeyFrame(Duration.millis(1000), e -> {
				seconds++;
				setTime();
			});
			    timeLine = new Timeline(kf);
				timeLine.setCycleCount(Timeline.INDEFINITE);
				timeLine.play();
			}

		}


	public TimeController() {
		hours = 0;
		minutes = 0;
		seconds = 0;

		timeLabel = new Label();
		timeLabel.setFont(Font.font("System", 48));
		setTime();
	}
	public void setTime() {
		if (seconds == 60) {
			seconds = 0;
			minutes++;

		}
		if (minutes == 60) {
			minutes = 0;
			hours++;

		}

		String h = hours >= 10 ? String.valueOf(hours) : "0" + String.valueOf(hours);
		String m = minutes >= 10 ? String.valueOf(minutes) : "0" + String.valueOf(minutes);
		String s = seconds >= 10 ? String.valueOf(seconds) : "0" + String.valueOf(seconds);

		timeLabel.setText(h + " : " + m + " : " + s);




	}
	public void clearButton(ActionEvent event) {
		timeLine.stop();
		hours = 0;
		minutes = 0;
		seconds = 0;
		setTime();
	}
	public void pauseButton(ActionEvent event){
		timeLine.pause();
	}
	public void reStartButton(ActionEvent event){
		timeLine.play();
	}

	// ��ư ����

	@FXML
	private Button changeBtn8;
	public void changeScene8() {
		try {
			Parent nextScene
					= FXMLLoader.load(getClass().getResource("Clock.fxml"));
			Scene scene = new Scene(nextScene);
			Stage primaryStage = (Stage) changeBtn8.getScene().getWindow();
			primaryStage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	private Button changeBtn9;
	public void changeScene9() {
		try {
			Parent nextScene
					= FXMLLoader.load(getClass().getResource("Post.fxml"));
			Scene scene = new Scene(nextScene);
			Stage primaryStage = (Stage) changeBtn9.getScene().getWindow();
			primaryStage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	private Button changeBtn10;
	public void changeScene10() {
		try {
			Parent nextScene
					= FXMLLoader.load(getClass().getResource("list.fxml"));
			Scene scene = new Scene(nextScene);
			Stage primaryStage = (Stage) changeBtn10.getScene().getWindow();
			primaryStage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
