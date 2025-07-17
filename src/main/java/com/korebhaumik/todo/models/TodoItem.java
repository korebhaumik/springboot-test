package com.korebhaumik.todo.models;

import java.util.UUID;

public class TodoItem{
    private final String id;
    private final String content;
    private boolean isCompleted;

    public TodoItem(String content){
        this.id = UUID.randomUUID().toString();;
        this.content = content;
        this.isCompleted = false;
    }

    public String getId() {
        return this.id;
    }

    public boolean isCompleted() {
        return this.isCompleted;
    }

    public void toggleCompleted() {
        this.isCompleted = !isCompleted;
    }

    public String getContent() {
        return this.content;
    }
}