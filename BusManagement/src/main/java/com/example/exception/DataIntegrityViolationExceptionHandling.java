package com.example.exception;

public class DataIntegrityViolationExceptionHandling extends RuntimeException{
    
    String sourceName;
    Long id;

    public DataIntegrityViolationExceptionHandling(String sourceName, Long id) {
        super(String.format("%s id - %s related data already used in another tables so you can not delete it , it is so risky, please avoid it.",sourceName,id));
        this.sourceName = sourceName;
        this.id = id;
    }
}
