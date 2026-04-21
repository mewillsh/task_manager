package com.example.talkmanager.dto.response;

import com.example.talkmanager.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseStatus {
    private String title;
    private Status status;
}
