package com.example.talkmanager.service;

import com.example.talkmanager.dto.request.RequestStatus;
import com.example.talkmanager.dto.request.RequestTask;
import com.example.talkmanager.dto.response.ResponseStatus;
import com.example.talkmanager.dto.response.ResponseTask;
import com.example.talkmanager.entity.Task;
import java.util.List;

public interface TaskService {
    Task createTask(RequestTask task);
    List<Task> findAllTask();
    Task findTaskById(Long id);
    ResponseTask updateTask(Long id, RequestTask user);
    ResponseTask deleteUserTask(Long id);
    ResponseStatus updateStatus(Long id, RequestStatus req);
}
