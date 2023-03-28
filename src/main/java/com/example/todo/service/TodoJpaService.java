/*
 * You can use the following import statements
 * 
 * i
 *
 */
package com.example.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
// Write your code here

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoJpaRepository;
import com.example.todo.repository.TodoRepository;

@Service 
public class TodoJpaService implements TodoRepository {
    @Autowired
    private TodoJpaRepository todoRepository;

    @Override
    public ArrayList<Todo> getTodos() {
        List<Todo> todoList = todoRepository.findAll();
        ArrayList<Todo> todo = new ArrayList<>(todoList);
        return todo;
    }

    @Override
    public Todo getTodoById(int id) {
        try {
            Todo todo = todoRepository.findById(id).get();
            return todo;
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Todo addTodo(Todo todo) {
        todoRepository.save(todo);
        return todo;
    }

    @Override
    public Todo updateTodo(int id, Todo todo) {
        try {
            Todo todos = todoRepository.findById(id).get();
            if (todo.getTodo() != null) {
                todos.setTodo(todo.getTodo());
            }
            if (todo.getStatus() != null) {
                todos.setStatus(todo.getStatus());
            }
            if (todo.getPriority() != null) {
                todos.setPriority(todo.getPriority());
            }
            return todoRepository.save(todos);
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteTodo(int id) {
        try {
            todoRepository.deleteById(id);
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
