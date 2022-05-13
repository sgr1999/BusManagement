package com.example.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataAlreadyPresentExceptionHandling extends RuntimeException{
    
    String resourceName;
    String fieldName;
    String fieldValue;
    Long fieldValue1;

    public DataAlreadyPresentExceptionHandling(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s is alredy registred with %s : %s", resourceName, fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public DataAlreadyPresentExceptionHandling(String resourceName, String fieldName, Long fieldValue1) {
        super(String.format("%s is alredy does exist in table with %s : %s", resourceName, fieldName,fieldValue1));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue1 = fieldValue1;
    }

    public DataAlreadyPresentExceptionHandling(String resourceName, String fieldName) {
        super(String.format("%s is alredy does exist in table with %s", resourceName, fieldName));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
    }

    public DataAlreadyPresentExceptionHandling(String resourceName) {
        super(String.format("%s is alredy does exist with %s", resourceName));
        this.resourceName = resourceName;
    }

    
}
