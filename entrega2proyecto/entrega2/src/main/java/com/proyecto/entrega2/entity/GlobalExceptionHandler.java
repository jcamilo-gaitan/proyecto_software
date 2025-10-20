package com.proyecto.entrega2.entity;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value=ValueOutOfRangeException.class)
    public ResponseEntity<Map<String, Object>> handleValueOutOfRangeException(ValueOutOfRangeException ex){
    Map<String, Object> response= new HashMap<>();
    response.put("error","Valor fuera de rango");
    response.put("message",ex.getMessage());
    response.put("timestamp", LocalDate.now());
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(com.fasterxml.jackson.databind.exc.InvalidFormatException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidFormatException(InvalidFormatException ex){
        Map<String, Object> response= new HashMap<>();
        if(ex.getTargetType().isEnum()){
            String campo=ex.getPath().get(0).getFieldName();
            String valor=ex.getValue().toString();
            String posibles=Arrays.toString(ex.getTargetType().getEnumConstants());
            response.put("error","valor invalido");
            response.put("variable ",campo);
            response.put("Valores posibles",posibles);
            response.put("timestamp",LocalDate.now());
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);

        }
        response.put("error","valor invalido");
        response.put("mensaje",ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
