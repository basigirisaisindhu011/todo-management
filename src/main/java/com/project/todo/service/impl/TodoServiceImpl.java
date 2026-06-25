package com.project.todo.service.impl;

import com.project.todo.dto.TodoDto;
import com.project.todo.entity.Todo;
import com.project.todo.exception.ResourceNotFoundException;
import com.project.todo.repository.TodoRepo;
import com.project.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepo todoRepo;
    private ModelMapper modelMapper;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {
       //convert tododto to todo jpa entity
//        Todo todo=new Todo();
//        todo.setTitle(todoDto.getTitle());
//        todo.setDescription(todoDto.getDescription());
//        todo.setCompleted(todoDto.isCompleted());
        Todo todo=modelMapper.map(todoDto,Todo.class);
        Todo savedTodo= todoRepo.save(todo);
     //convert savedtodo to savedtodoDto
//
        TodoDto savedTodoDto=modelMapper.map(savedTodo, TodoDto.class);

        return savedTodoDto;
    }

    @Override
    public TodoDto getTodo(Long id) {
        Todo todo=todoRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Todo is not found with id:"+id));

        return modelMapper.map(todo, TodoDto.class);
    }

    @Override
    public List<TodoDto> getAllTodos() {
        List<Todo> todos=todoRepo.findAll();

        return todos.stream().map((todo)-> modelMapper.map(todo,TodoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TodoDto updateTodo(Long id, TodoDto todoDto) {

        Todo todo=todoRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Todo is not found with id:"+id));

        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());
        Todo updateTodo=todoRepo.save(todo);
        return modelMapper.map(updateTodo, TodoDto.class);
    }

    @Override
    public void deleteTodo(Long id) {
        Todo todo=todoRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Todo is not found with id:"+id));

        todoRepo.deleteById(id);
    }

    @Override
    public TodoDto completeTodo(Long id) {
        Todo todo=todoRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Todo is not found with id:"+id));
        todo.setCompleted(Boolean.TRUE);
        Todo updatedTodo=todoRepo.save(todo);
        return modelMapper.map(updatedTodo, TodoDto.class);
    }

    @Override
    public TodoDto incompleteTodo(Long id) {
        Todo todo=todoRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Todo is not found with id:"+id));
        todo.setCompleted(Boolean.FALSE);
        Todo updatedTodo=todoRepo.save(todo);
        return modelMapper.map(updatedTodo, TodoDto.class);
    }
}
