package com.example.handler;

import lombok.*;

@Getter
@Setter
public class EntityNotFoundException extends RuntimeException{
    
    String resourceName;
    String fieldName;
    long fieldValue;
    public EntityNotFoundException(String resourceName, String fieldName, long fieldValue) {
        super(String.format("%s not found with %s : %s", resourceName, fieldName));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
  
}
