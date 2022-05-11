package com.example.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataAlreadyPresentExceptionHandling extends RuntimeException{
    
    String resourceName;
    String fieldName;
    String fieldValue;

    public DataAlreadyPresentExceptionHandling(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s is alredy registred with %s : %s", resourceName, fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    
}
