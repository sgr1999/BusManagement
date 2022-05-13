package com.example.exception;

public class DataNotMatchException extends RuntimeException{
    
    String sourceName;
    String fieldName;
    String fieldValue;
    Long id;
    public DataNotMatchException(String fieldName, String fieldValue, Long id) {
        super(String.format("%s data not not match with this %s : %s , please check userName with this id, also if you trying to update userName it cann't update", fieldName, fieldValue,id));
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.id = id;
    }

    
   
    public DataNotMatchException(String sourceName, String fieldName, String fieldValue, Long id) {
        super(String.format("%s data not not match with this %s : %s , please check userName with this id, also if you trying to update userName it cann't update",sourceName, fieldName, fieldValue,id));
        this.sourceName = sourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.id = id;
    }



    public DataNotMatchException(Long id) {
        super(String.format("Please check id properly because it is not have this id - %s related data, and it is already does exist in database so you can not update it", id));
        this.id = id;
    }

    

    

}
