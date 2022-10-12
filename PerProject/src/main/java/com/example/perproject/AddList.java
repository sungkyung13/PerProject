package com.example.perproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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

    public TodoItem processResults() {
        String TaskName = TaskField.getText().trim();
        String Details = DetailsArea.getText().trim();
        String Time = TimeField.getText().trim();
        LocalDate deadlineValue = DeadLine.getValue();

        TodoItem newItem = new TodoItem(TaskName, Details, Time, deadlineValue);
        TodoData.getInstance().addTodoItem(newItem);
        return newItem;
    }

}
