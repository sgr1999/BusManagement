package com.example.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataAlreadyPresentExceptionHandling {
    
    String resourceName;
    String fieldName;
    long fieldValue;

    public DataAlreadyPresentExceptionHandling(String resourceName, String fieldName, long fieldValue) {
        //super(String.format("arg0", arg1, arg2));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    
}
