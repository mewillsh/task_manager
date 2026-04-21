package com.example.talkmanager.dto.response;

import com.example.talkmanager.entity.enums.Priority;
import com.example.talkmanager.entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTask {
    private String title;
    private String description;
    private Status status;
    private Priority priority;
}
