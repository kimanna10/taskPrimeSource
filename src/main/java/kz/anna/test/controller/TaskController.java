package kz.anna.test.controller;

import kz.anna.test.entity.Task;
import kz.anna.test.repository.TaskRepository;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/all")  //  get all books from db
    public List<Task> getAllBooks(){
        return taskRepository.findAll();
    }

    @GetMapping("/find/{id}")  //  get task by id
    public Task getTaskById(@PathVariable int id){
        return taskRepository.findById(id).get();
    }

    @PostMapping("/create")   //  create task
    public Task createTask(@RequestBody Task task) {
        return taskRepository.saveAndFlush(task);
    }
    @PutMapping("/update/{id}") //  update task by id
    public Task updateTask(@PathVariable int id, @RequestBody Task task){
        task.setId(id);
        return taskRepository.saveAndFlush(task);
    }

    @DeleteMapping("/delete/{id}") // delete task by id
    public void deleteTask(@PathVariable int id, @RequestBody Task task){
        task.setId(id);
        taskRepository.delete(task);
    }





}
