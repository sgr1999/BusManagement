package com.example.handler;

import com.example.exception.DataAlreadyPresentExceptionHandling;
import com.example.exception.DataNotMatchException;
import com.example.exception.ResourceNotFoundException;
import com.example.response.ApiResponse;
import com.example.response.ApiResponse1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){

        String message = ex.getMessage();
        ApiResponse apiResponse = new ApiResponse(message, false);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataAlreadyPresentExceptionHandling.class)
    public ResponseEntity<ApiResponse1> dataAlreadyPresent(DataAlreadyPresentExceptionHandling ex){

        String message = ex.getMessage();
        ApiResponse1 apiResponse = new ApiResponse1(message);
        return new ResponseEntity<ApiResponse1>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(DataNotMatchException.class)
    public ResponseEntity<ApiResponse1> idNotMatchWithUserName(DataNotMatchException ex){

        String message = ex.getMessage();
        ApiResponse1 apiResponse = new ApiResponse1(message);
        return new ResponseEntity<ApiResponse1>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
