package com.prepare.API_JDBC.Controllers;

import com.prepare.API_JDBC.Models.ResponseServe;
import com.prepare.API_JDBC.Utils.Messages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.crypto.interfaces.PBEKey;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ResponseServe> getErrores(RuntimeException error){
        Messages detailsError = Messages.valueOf(error.getMessage());
        ResponseServe responseServe = detailsError.obtenerError();
        return new ResponseEntity<>(responseServe, HttpStatus.valueOf(error.getMessage()));
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> errorsValidation( MethodArgumentNotValidException error){
        /*String code = String.valueOf(error.getStatusCode());
        ResponseServe responseServe = new ResponseServe(code, null);
        error.getBindingResult().getAllErrors().forEach((e) -> {
            String fieldName = ((FieldError) e).getField();
            String objectName = ((FieldError) e).getObjectName();
            String message = e.getDefaultMessage();
            responseServe.setMESSAGE(message);
            responseServe.setFIELD(fieldName);
            responseServe.setOBJECT(objectName);
        });*/
        return new ResponseEntity<>(error.getBindingResult().getAllErrors(), error.getStatusCode());
    }

}
