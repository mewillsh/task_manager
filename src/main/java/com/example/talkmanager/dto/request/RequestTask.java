package com.example.talkmanager.dto.request;

import com.example.talkmanager.entity.enums.Priority;
import com.example.talkmanager.entity.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestTask {
    @NotBlank(message = "Title Cannot be Null") @Size(max=100)
    private String title;
    @Size(max=500)
    private String description;
    private Status status;
    private Priority priority;
}
