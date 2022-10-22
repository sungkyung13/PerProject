package com.example.perproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

public class TodoData {
    private static TodoData instance = new TodoData();
    private static String filename = "TodoListItem.txt";

    private ObservableList<TodoItem> todoItems;
    private DateTimeFormatter formatter;

    public static TodoData getInstance() {
        return instance;
    }

    private TodoData() {
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public ObservableList<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void addTodoItem(TodoItem item) {
        todoItems.add(item);
    }


// txt 파일에 할 일 추가
    public void loadTodoItems() throws IOException {

        todoItems = FXCollections.observableArrayList();
        // 파일에서 입력 받음
        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);

        String input;

        try {
            while ((input = br.readLine()) != null) { // null이 될때까지 값을 가져옴
                String[] itemPieces = input.split("\t");

                String TaskName = itemPieces[0];
                String Details = itemPieces[1];
                String Time = itemPieces[2];
                String dateString = itemPieces[3];

                LocalDate date = LocalDate.parse(dateString, formatter);
                TodoItem todoItem = new TodoItem(TaskName, Details, Time, date);
                todoItems.add(todoItem);
            }

        } finally {
            if(br != null) {
                br.close();
            }
        }
    }

    // To do 저장 되어 있는 요소 출력
    public void storeTodoItems() throws IOException {

        //txt 파일 불러오기
        Path path = Paths.get(filename);
        //txt 파일에서 출력
        BufferedWriter bw = Files.newBufferedWriter(path);
        try {
            Iterator<TodoItem> iter = todoItems.iterator();
            while(iter.hasNext() == true) {
                TodoItem item = iter.next();
                //item 뒤의 요소를 가져온다.
                bw.write(String.format("%s\t%s\t%s\t%s",
                        item.getTaskName(),
                        item.getDetails(),
                        item.getTime(),
                        item.getDeadline().format(formatter)));
                bw.newLine();
            }

        } finally {
            if(bw != null) {
                bw.close();
            }
        }
    }

    public void deleteTodoItem(TodoItem item) {
        todoItems.remove(item);
    }
}
