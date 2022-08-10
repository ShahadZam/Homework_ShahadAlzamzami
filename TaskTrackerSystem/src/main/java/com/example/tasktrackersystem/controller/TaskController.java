package com.example.tasktrackersystem.controller;

import com.example.tasktrackersystem.model.ApiResponse;
import com.example.tasktrackersystem.model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class TaskController {


    public ArrayList<Task> listTasks;

    public TaskController() {
        listTasks =new ArrayList<Task>();
    }

    @GetMapping("/tsk")
    public ArrayList getListTasks(){
        return listTasks;
    }



    @PostMapping("/tsk")
    public ApiResponse setGrade(@RequestBody Task task){
        listTasks.add(task);
        return new ApiResponse("task added");
    }


    @PutMapping("/tsk/{index}")
    public ApiResponse updateGrade(@PathVariable int index,@RequestBody Task task){
        listTasks.set(index,task);
        return new ApiResponse("task updated");
    }


    @PutMapping("/tsk/status/{index}")
    public ApiResponse ChangeStatus (@PathVariable int index,@RequestBody String status){
        listTasks.get(index).setStatus(status);
        return new ApiResponse("status updated");
    }

    @GetMapping("tsk/search/{title}")
    Optional<Task> getTaskByTitle(@PathVariable String title) {
        for (Task task : listTasks) {
            if (title.equals(task.getTitle())) {
                return Optional.of(task);
            }
        }
        return Optional.empty();
    }

    @DeleteMapping("/tsk/{index}")
    public ApiResponse deleteGrade(@PathVariable int index){
        String name= listTasks.get(index).getTitle();
        listTasks.remove(index);
        return new ApiResponse("task: " +name+" deleted");
    }


}
