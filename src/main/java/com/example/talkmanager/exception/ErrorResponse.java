package com.example.talkmanager.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private LocalDateTime timestamp=LocalDateTime.now();
    private int Status;
    private String Error;
    private String Message;
    private StringBuffer Path;

}
