package com.example.exception;

public class DataNotMatchException extends RuntimeException{
    
    String fieldName;
    String fieldValue;
    Long id;
    public DataNotMatchException(String fieldName, String fieldValue, Long id) {
        super(String.format("%s data not not match with this %s : %s , please check userName with this id, also if you trying to update userName it cann't update", fieldName, fieldValue,id));
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.id = id;
    }

}
