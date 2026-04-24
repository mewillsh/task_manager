package com.example.talkmanager.service;

import com.example.talkmanager.dto.request.RequestTask;
import com.example.talkmanager.entity.Task;
import com.example.talkmanager.repository.TaskRepository;
import jakarta.validation.constraints.Null;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static com.example.talkmanager.entity.enums.Priority.MEDIUM;
import static com.example.talkmanager.entity.enums.Status.PENDING;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
        requestTask=new RequestTask("Do DSA","Do DSA",PENDING,MEDIUM);
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

}
