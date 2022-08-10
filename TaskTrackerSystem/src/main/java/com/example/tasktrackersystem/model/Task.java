package com.example.tasktrackersystem.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Task {

    private String title;
    private String description;
    private String status;
    private String deadline;

}
