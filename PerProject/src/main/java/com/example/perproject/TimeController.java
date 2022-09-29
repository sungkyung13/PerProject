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
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
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
	private Boolean isStart = false; // 시작인지 판단할 필드.
	private Timeline timeLine;
	private DoubleProperty timeSeconds = new SimpleDoubleProperty();
	private DoubleProperty timeMinutes = new SimpleDoubleProperty();
	private DoubleProperty timeHours = new SimpleDoubleProperty();
	private Duration time = Duration.ZERO;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		timeLine = new Timeline(); // timeLine 객체 초기화
		timeLine.setCycleCount(Timeline.INDEFINITE);
		timeLine.play();

	}

	public void newButton(ActionEvent event){
		timeLine.pause(); // 새로 시간을 측정하려면 timeLine이 초기화되야 하므로 stop()
		time = Duration.ZERO; // time의 값도 새로 측정 할 때마다 0이되어야 함.
		isStart = true; //newButton을 클릭했으므로 isStart 값 true로
		if(isStart == true){

			if (timeLine == null) {
				// 딱히 할 거 없음.
			} else {
				timeLine = new Timeline(
						new KeyFrame(Duration.millis(1000),
								new EventHandler<ActionEvent>() {
									@Override
									public void handle(ActionEvent t) {
										Duration duration = ((KeyFrame)t.getSource()).getTime();
										time = time.add(duration);
										timeSeconds.set(time.toSeconds());
									}
								})
				);

				timeLine.setCycleCount(Timeline.INDEFINITE);
				timeLine.play();
			}

		}
	}

	public TimeController() {
		hours = 0;
		minutes = 0;
		seconds = 0;

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
		timeLine.pause(); //timeLine멈춤
	}
	public void reStartButton(ActionEvent event){
		timeLine.play(); // timeLine 이어서 재시작
	}




}
