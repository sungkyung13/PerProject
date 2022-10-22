package com.example.perproject;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class List implements Initializable{
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Items = FXCollections.observableArrayList();
        todoListView.setItems(Items);
    }



    @FXML
    private TextField TaskField;

    @FXML
    private TextArea DetailsArea;

    @FXML
    private TextField TimeField;

    @FXML
    private DatePicker DateDeadLine;

    private ObservableList<TodoItem> Items;

    // txt add
    public TodoItem ProcessResults() {
        String TaskName = TaskField.getText().trim();
        String Details = DetailsArea.getText().trim();
        String Time = TimeField.getText().trim();
        LocalDate DeadLineValue = DateDeadLine.getValue();

        TodoItem newItem = new TodoItem(TaskName, Details, Time, DeadLineValue);
        TodoData.getInstance().addTodoItem(newItem);
        return newItem;
    }

    // add 버튼
    public void AddTodo() {

        String TaskName = TaskField.getText();
        if (TaskName.isEmpty()) {
            alert("할 일의 이름을 입력하셔야 합니다.", null);
            return;
        }

        String Details = DetailsArea.getText();
        if (Details.isEmpty()) {
            alert("내용을 입력하셔야 합니다.", null);
            return;

        }

        String Time = TimeField.getText();
        if (Time.isEmpty()) {
            alert("시간을 입력하셔야 합니다.", null);
            return;
        }


        LocalDate deadlineValue = DateDeadLine.getValue();
        if (deadlineValue == null) {
            alert("날짜를 입력하세요", null);
            return;
        }

        TodoItem newItem = ProcessResults();
        Items.add(newItem);
        todoListView.getSelectionModel().select(newItem);
    }

    public void alert(String msg, String header) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("!");
        alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.show();
    }

    //Delete Button 구현
    public void DeleteTodo() {
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
        if (item != null) {
            TodoData.getInstance().deleteTodoItem(item);
        }
    }



    @FXML
    private ListView<TodoItem> todoListView;

    @FXML
    private TextArea ItemDetails;

    @FXML
    private Label DeadLine;

    @FXML
    private Label Time;


    @FXML
    private AnchorPane MainAnchorPane;

    private Predicate<TodoItem> wantAllItems;

    public void initialize() {
        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observable, TodoItem oldValue, TodoItem newValue) {
                if (newValue != null) {
                    TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                    ItemDetails.setText(item.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy, MMMM d");
                    DeadLine.setText(df.format(item.getDeadline()));
                    Time.setText(item.getTime());
                }
            }
        });

        wantAllItems = new Predicate<TodoItem>() {
            @Override
            public boolean test(TodoItem todoItem) {
                return true;
            }
        };

        todoListView.setItems(TodoData.getInstance().getTodoItems());
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();

        todoListView.setCellFactory(new Callback<ListView<TodoItem>, ListCell<TodoItem>>() {
            @Override
            public ListCell<TodoItem> call(ListView<TodoItem> param) {
                ListCell<TodoItem> cell = new ListCell<TodoItem>() {
                    @Override
                    protected void updateItem(TodoItem item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setText(null);
                        } else {
                            setText(item.getTaskName());
                            if (item.getDeadline().isBefore(LocalDate.now().plusDays(1))) {
                                setTextFill(Color.BLACK);
                            } else if (item.getDeadline().equals(LocalDate.now().plusDays(1))) {
                                setTextFill(Color.BROWN);
                            }
                        }
                    }
                };
                return cell;
            }
        });
    }




    @FXML
    public void handleClickListView() {
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
        ItemDetails.setText(item.getDetails());
        DeadLine.setText(item.getDeadline().toString());
        Time.setText(TimeField.getText());
    }


 // 왼쪽 바 부분 화면 전환 버튼
    @FXML
    private Button ClockBtn;
    public void changeScene11() {
        try {
            Parent nextScene
                    = FXMLLoader.load(getClass().getResource("Clock.fxml"));
            Scene scene = new Scene(nextScene);
            Stage primaryStage = (Stage) ClockBtn.getScene().getWindow();
            primaryStage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button ListBtn;
    public void changeScene13() {
        try {
            Parent nextScene
                    = FXMLLoader.load(getClass().getResource("list.fxml"));
            Scene scene = new Scene(nextScene);
            Stage primaryStage = (Stage) ListBtn.getScene().getWindow();
            primaryStage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
