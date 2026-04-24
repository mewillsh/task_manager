package com.example.talkmanager.dto.request;

import com.example.talkmanager.entity.enums.Priority;
import com.example.talkmanager.entity.enums.Status;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTaskRequest {
    @Size(max = 100)
    @Pattern(regexp = ".*\\S.*", message = "Title cannot be blank")
    private String title;

    @Size(max = 500)
    private String description;

    private Status status;

    private Priority priority;

    @FutureOrPresent(message = "Due date cannot be in the past")
    private LocalDateTime due_date;
}
