package com.example.talkmanager.service;

import com.example.talkmanager.dto.request.RequestStatus;
import com.example.talkmanager.dto.request.RequestTask;
import com.example.talkmanager.dto.request.UpdateTaskRequest;
import com.example.talkmanager.dto.response.ResponseStatus;
import com.example.talkmanager.dto.response.ResponseTask;
import com.example.talkmanager.entity.Task;
import com.example.talkmanager.repository.TaskRepository;
import com.example.talkmanager.exception.TaskNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.example.talkmanager.entity.enums.Priority.MEDIUM;
import static com.example.talkmanager.entity.enums.Status.PENDING;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class Calcualtor{
    public int add(int a,int b){
        return a+b;
    }
}
@ExtendWith(MockitoExtension.class)
public class taskManagerServiceTest {
    @Mock
    TaskRepository taskRepository;
    @InjectMocks
    TaskServiceImp taskService;
    RequestTask requestTask;
    @BeforeEach
    void initial(){
        requestTask=new RequestTask("Do DSA","Do DSA",PENDING,MEDIUM, null);
    }
    @Test
    @DisplayName("Testing Save Task Service")
    public void SaveTaskTest(){
        Task savedTask=new Task( 52L,"Do DSA","Do DSA",PENDING,MEDIUM, null, LocalDateTime.now());
        when(taskRepository.save(any(Task.class))).thenReturn(savedTask);
        Task createdTask=taskService.createTask(requestTask);
        assertNotNull(createdTask);
        assertEquals("Do DSA",createdTask.getTitle());
        verify(taskRepository,times(1)).save(any(Task.class));
    }

    @Test
    @DisplayName("Throws when task not found")
    public void FindTaskByIdNotFoundTest(){
        when(taskRepository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(TaskNotFoundException.class, () -> taskService.findTaskById(99L));
        verify(taskRepository,times(1)).findById(99L);
    }

    @Test
    @DisplayName("Update task with partial fields")
    public void UpdateTaskPartialTest(){
        Task existing=new Task( 10L,"Old","Old",PENDING,MEDIUM, null, LocalDateTime.now());
        UpdateTaskRequest update=new UpdateTaskRequest("New Title", null, null, null, null);
        when(taskRepository.findById(10L)).thenReturn(Optional.of(existing));
        when(taskRepository.save(any(Task.class))).thenReturn(existing);

        ResponseTask response=taskService.updateTask(10L, update);
        assertEquals("New Title", response.getTitle());
        verify(taskRepository,times(1)).save(any(Task.class));
    }

    @Test
    @DisplayName("Update status")
    public void UpdateStatusTest(){
        Task existing=new Task( 11L,"Title","Desc",PENDING,MEDIUM, null, LocalDateTime.now());
        RequestStatus requestStatus=new RequestStatus(com.example.talkmanager.entity.enums.Status.COMPLETED);
        when(taskRepository.findById(11L)).thenReturn(Optional.of(existing));
        when(taskRepository.save(any(Task.class))).thenReturn(existing);

        ResponseStatus response=taskService.updateStatus(11L, requestStatus);
        assertEquals(com.example.talkmanager.entity.enums.Status.COMPLETED, response.getStatus());
        verify(taskRepository,times(1)).save(any(Task.class));
    }

}
