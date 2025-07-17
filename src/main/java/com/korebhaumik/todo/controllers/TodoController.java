package com.korebhaumik.todo.controllers;

import com.korebhaumik.todo.models.TodoItem;
import com.korebhaumik.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todos")
public class TodoController{
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService){
      this.todoService = todoService;
    }

    @GetMapping
    public List<TodoItem> getTodos(){
        return todoService.getAllTodos();
    }

    @PostMapping("/addData")
    public List<TodoItem> addTodo(@RequestBody String content){
        return todoService.addTodo(content);
    }

    @GetMapping("/{id}")
    public Optional<TodoItem> getTodoById(@PathVariable String id){
        return todoService.getTodoById(id);
    }

    @PutMapping("/toggleCompleted/{id}")
    public List<TodoItem> toggleCompletedById(@PathVariable String id){
        todoService.toggleCompletedById(id);
        return todoService.getAllTodos();
    }

    @DeleteMapping("/delete/{id}")
    public List<TodoItem> deleteTodoById(@PathVariable String id){
        return todoService.deleteTodoById(id);
    }

}