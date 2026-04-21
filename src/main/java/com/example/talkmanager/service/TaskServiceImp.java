package com.example.talkmanager.service;

import com.example.talkmanager.dto.request.RequestStatus;
import com.example.talkmanager.dto.request.RequestTask;
import com.example.talkmanager.dto.response.ResponseStatus;
import com.example.talkmanager.dto.response.ResponseTask;
import com.example.talkmanager.entity.Task;
import com.example.talkmanager.exception.TaskNotFoundException;
import com.example.talkmanager.repository.TaskRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.slf4j.Logger;

@Service
public class TaskServiceImp implements TaskService{
    @Autowired
    TaskRepository taskRepository;
    private static final Logger logger=LoggerFactory.getLogger(TaskServiceImp.class);
    public void run(){
        logger.info("Application is Started");
        logger.debug("Debugging Info");
        logger.error("Something went wrong");
    }
    @Override
    public Task createTask(RequestTask task) {
        logger.info("Creating new task with title {}",task.getTitle());
        Task newTask=new Task(task.getTitle(),task.getDescription(),task.getStatus(),task.getPriority());
        taskRepository.save(newTask);
        logger.debug("Created new task with ID: {}",newTask.getId());
        return newTask;
    }

    @Override
    public List<Task> findAllTask() {
        logger.info("Finding All the Task");
        return taskRepository.findAll();
    }

    @Override
    public Task findTaskById(Long id) {
        logger.info("Finding task with id: {}",id);
        return taskRepository.findById(id).orElseThrow(()->{
                logger.debug("Didn't find task with this ID: {}",id);
                return new TaskNotFoundException("Task Not Found");});
    }

    @Override
    public ResponseTask updateTask(Long id, RequestTask req) {
        Task task=taskRepository.findById(id).orElseThrow(()->{
            logger.error("Didn't Found Task with this ID: {}",id);
            return new TaskNotFoundException("Task not Found");});
        if(req.getTitle()!=null){
            task.setTitle(req.getTitle());
        }
        if(req.getDescription()!=null){
            task.setDescription(req.getDescription());
        }
        if(req.getPriority()!=null){
            task.setPriority(req.getPriority());
        }
        if(req.getStatus()!=null){
            task.setStatus(req.getStatus());
        }
        taskRepository.save(task);
        logger.debug("Updated Task with ID: {}",id);
        return new ResponseTask(task.getTitle(),task.getDescription(),task.getStatus(),task.getPriority());
    }

    @Override
    public ResponseTask deleteUserTask(Long id) {
        Task task=taskRepository.findById(id).orElseThrow(()->{
            logger.error("Didn't Found task with this ID: {}",id);
            return new TaskNotFoundException("Task not Found");});
        taskRepository.deleteById(id);
        logger.debug("Deleted Task with ID: {}",id);
        return new ResponseTask(task.getTitle(),task.getDescription(),task.getStatus(),task.getPriority());
    }

    @Override
    public ResponseStatus updateStatus(Long id, RequestStatus req) {
        Task task=taskRepository.findById(id).orElseThrow(()->{
            logger.error("Task Not found with given ID: {}",id);
            return new TaskNotFoundException("Task not Found");});
        task.setStatus(req.getStatus());
        taskRepository.save(task);
        logger.debug("Task Status updated Successfully with ID: {}",id);
        return new ResponseStatus(task.getTitle(),task.getStatus());
    }
}
