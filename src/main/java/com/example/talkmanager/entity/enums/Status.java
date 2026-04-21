package com.example.talkmanager.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Status {
    COMPLETED,
    PENDING,
    IN_PROCESS;
    @JsonCreator
    public static Status form(String val){
        try{
            return Status.valueOf(val.toUpperCase());
        }
        catch(Exception e){
            throw new IllegalArgumentException("Status value is Invalid "+val);
        }
    }
}
