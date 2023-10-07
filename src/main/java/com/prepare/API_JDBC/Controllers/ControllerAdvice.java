package com.prepare.API_JDBC.Controllers;

import com.prepare.API_JDBC.Models.ResponseServe;
import com.prepare.API_JDBC.Utils.Messages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ResponseServe> getErrores(RuntimeException error){
        Messages detailsError = Messages.valueOf(error.getMessage());
        ResponseServe responseServe = detailsError.obtenerError();
        return new ResponseEntity<>(responseServe, HttpStatus.valueOf(error.getMessage()));
    }

}
