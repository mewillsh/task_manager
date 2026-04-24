package com.example.talkmanager.entity;

import com.example.talkmanager.entity.enums.Priority;
import com.example.talkmanager.entity.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false) @Size(max=100, message = "Size should be less then 100")
    private String title;
    @Size(max=500)
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status=Status.PENDING;
    @Enumerated(EnumType.STRING) 
    private Priority priority = Priority.MEDIUM;
    @Column(nullable = true)
    @FutureOrPresent(message = "Due date cannot be in the past")
    private LocalDateTime due_date;
    @CreatedDate
    private LocalDateTime created_at=LocalDateTime.now();
    public Task(String title,String description,Status status,Priority priority){
        this.title=title;
        this.description=description;
        this.status=status;
        this.priority=priority;
    }
}
