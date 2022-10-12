package com.example.perproject;

import java.time.LocalDate;

public class TodoItem {
    private String TaskName;
    private String Time;
    private String Details;
    private LocalDate DeadLine;


    public TodoItem(String TaskName, String Details, String Time, LocalDate Deadline) {
        this.TaskName = TaskName;
        this.Details = Details;
        this.Time = Time;
        this.DeadLine = Deadline;

    }

    public String getTaskName() {
        return TaskName;
    }

    public void TaskName(String TaskName) {
        this.TaskName = TaskName;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String Details) {
        this.Details = Details;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public LocalDate getDeadline() {
        return DeadLine;
    }

    public void setDeadline(LocalDate deadline) {
        this.DeadLine = deadline;
    }
}
