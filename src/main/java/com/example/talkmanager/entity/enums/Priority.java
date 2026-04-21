package com.example.talkmanager.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Priority {
    LOW,
    MEDIUM,
    HIGH;
    @JsonCreator
    public static Priority form(String value){
        try {
            return Priority.valueOf(value.toUpperCase());
        }
        catch(Exception e) {
            throw new IllegalArgumentException("Invalid Value " + value);
        }
    }
}
