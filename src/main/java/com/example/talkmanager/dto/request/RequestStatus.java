package com.example.talkmanager.dto.request;

import com.example.talkmanager.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestStatus {
    private Status status;
}
