package com.example.schoolmanagementdb.advice;

import com.example.schoolmanagementdb.dto.ApiResponse;
import com.example.schoolmanagementdb.exception.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvise {


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        String message=methodArgumentNotValidException.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(new ApiResponse(message,400));
    }

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<ApiResponse> apiException(ApiException apiException){
        String message=apiException.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(message,400));
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ApiResponse> exception(Exception exception){
        exception.printStackTrace();
        return ResponseEntity.status(500).body(new ApiResponse("SERVER ERROR !",500));
    }
}