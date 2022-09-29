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
	private Boolean isStart = false; // �������� �Ǵ��� �ʵ�.
	private Timeline timeLine;
	private DoubleProperty timeSeconds = new SimpleDoubleProperty();
	private DoubleProperty timeMinutes = new SimpleDoubleProperty();
	private DoubleProperty timeHours = new SimpleDoubleProperty();
	private Duration time = Duration.ZERO;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		timeLine = new Timeline(); // timeLine ��ü �ʱ�ȭ
		timeLine.setCycleCount(Timeline.INDEFINITE);
		timeLine.play();

	}

	public void newButton(ActionEvent event){
		timeLine.pause(); // ���� �ð��� �����Ϸ��� timeLine�� �ʱ�ȭ�Ǿ� �ϹǷ� stop()
		time = Duration.ZERO; // time�� ���� ���� ���� �� ������ 0�̵Ǿ�� ��.
		isStart = true; //newButton�� Ŭ�������Ƿ� isStart �� true��
		if(isStart == true){

			if (timeLine == null) {
				// ���� �� �� ����.
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
		timeLine.pause(); //timeLine����
	}
	public void reStartButton(ActionEvent event){
		timeLine.play(); // timeLine �̾ �����
	}




}
