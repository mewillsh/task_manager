package com.example.talkmanager.dto.request;

import com.example.talkmanager.entity.enums.Status;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestStatus {
    @NotNull(message = "Status cannot be null")
    private Status status;
}
