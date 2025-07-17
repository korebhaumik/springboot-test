package com.korebhaumik.todo.services;

import com.korebhaumik.todo.models.TodoItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoService{
    List<TodoItem> todos = new ArrayList<TodoItem>();

    public List<TodoItem> getAllTodos(){
        return todos;
    }

    public List<TodoItem> addTodo(String content){
        todos.add(new TodoItem(content));
        return todos;
    }

    public void toggleCompletedById(String id) {
        for (TodoItem todoItem : todos) {
            if (todoItem.getId().equals(id)) {
                todoItem.toggleCompleted();
                break;
            }
        }
    }

    public Optional<TodoItem> getTodoById(String id){
        return todos.stream().filter(todoItem -> todoItem.getId().equals(id)).findFirst();
    }

    public List<TodoItem> deleteTodoById(String id){
        todos.removeIf(todoItem -> todoItem.getId().equals(id));
        return todos;
    }
}