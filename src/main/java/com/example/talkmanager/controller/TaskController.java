package com.example.talkmanager.controller;

import com.example.talkmanager.dto.request.RequestStatus;
import com.example.talkmanager.dto.request.RequestTask;
import com.example.talkmanager.dto.response.ResponseTask;
import com.example.talkmanager.entity.Task;
import com.example.talkmanager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.talkmanager.dto.response.ResponseStatus;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService taskService;
    @PostMapping("/create")
    public ResponseEntity<Task> createTask(@Valid @RequestBody RequestTask requestTask){
        Task curr=taskService.createTask(requestTask);
        return ResponseEntity.status(201).body(curr);
    }
    @GetMapping
    public ResponseEntity<List<Task>> getAllTask(){
        List<Task> allTask=taskService.findAllTask();
        return ResponseEntity.status(200).body(allTask);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@Valid @PathVariable Long id){
        Task currTask=taskService.findTaskById(id);
        return ResponseEntity.status(200).body(currTask);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<ResponseTask> updateTask(@Valid @RequestBody RequestTask requestTask,@PathVariable Long id){
        ResponseTask task=taskService.updateTask(id,requestTask);
        return ResponseEntity.status(200).body(task);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteTask(@Valid @PathVariable Long id){
        taskService.deleteUserTask(id);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/status/{id}")
    public ResponseEntity<ResponseStatus> updateStatus(@Valid @RequestBody RequestStatus req,@PathVariable Long id){
        ResponseStatus resStatus= taskService.updateStatus(id, req);
        return ResponseEntity.status(200).body(resStatus);
    }
}
