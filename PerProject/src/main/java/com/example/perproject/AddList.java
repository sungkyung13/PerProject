package com.example.perproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.time.LocalDate;

public class AddList {
    @FXML
    private TextField TaskField;

    @FXML
    private TextField TimeField;

    @FXML
    private TextArea DetailsArea;

    @FXML
    private DatePicker DeadLine;

    private ListView<TodoItem> todoListView;

    private ObservableList<TodoItem> items;

    @FXML
    private void initialize() {
        todoListView = FXCollections.observableArrayList();
        todoListView.setItems(items);
    }

    public TodoItem processResults() {
        String TaskName = TaskField.getText().trim();
        String Details = DetailsArea.getText().trim();
        String Time = TimeField.getText().trim();
        LocalDate deadlineValue = DeadLine.getValue();

        TodoItem newItem = new TodoItem(TaskName, Details, Time, deadlineValue);

    }


}
