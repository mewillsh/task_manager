package com.example.talkmanager.entity;

import com.example.talkmanager.entity.enums.Priority;
import com.example.talkmanager.entity.enums.Status;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;
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
    @Size(max=100)
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status=Status.PENDING;
    @Enumerated(EnumType.STRING) 
    private Priority priority = Priority.MEDIUM;
    @Column(nullable = true)
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
