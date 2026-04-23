package com.example.Exercise.Controller_layer_REST_CRUD._Q1.Controller;

import com.example.Exercise.Controller_layer_REST_CRUD._Q1.Model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    ArrayList<Task> tasks = new ArrayList<>();


    @GetMapping("/display")
    public ArrayList<Task> getTasks(){
        return tasks ;
    }//display all task


    @PostMapping("/create-task")
    public String createNewTask(@RequestBody Task task){
        tasks.add(task);
        return "Task added successfully !";
    }//create new task


    @DeleteMapping("/delete-task/{index}")
    public String deleteTask(@PathVariable int index){
        tasks.remove(index);
        return "Task removed successfully !";
    }//remove task

    @PutMapping("/update-task/{index}")
    public String updateTask(@PathVariable int index , @RequestBody Task task){
        tasks.set(index , task);
        return "Task update successfully !";
    }//update task


    @PutMapping("/change-status/{index}")
    public String changeTaskStatus(@PathVariable int index){
        Task task = tasks.get(index);
        if(task.isStatus()){
            task.setStatus(false);
        }
        else{
            task.setStatus(true);
        }
        return "Task status changed successfully!";

    }//change task status

    @GetMapping("/search/{title}")
    public Task searchTaskByTitle (@PathVariable String title){
        for(int i = 0 ; i < tasks.size() ; i++){
            if(tasks.get(i).getTitle().equals(title)){
                return tasks.get(i);
            }
        }
        return null ;
    }













}
