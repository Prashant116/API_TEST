package com.example.API_TEST.Exception;

import com.example.API_TEST.model.ErrorResponse;
import jakarta.el.MethodNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoHandlerFoundException(NoHandlerFoundException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                "Requested resource was not found on server",
                request.getDescription(false)
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

    }
        @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
        public final ResponseEntity<ErrorResponse> handleMethodNotFoundException(HttpRequestMethodNotSupportedException ex, WebRequest request)
        {
            StringBuilder supportedMethods = new StringBuilder();
            if (ex.getSupportedHttpMethods() != null) {
                supportedMethods.append(" Supported methods are ");
//                supportedMethods.append(
//                        ex.getSupportedHttpMethods()
//                                .stream()
//                                .map(Enum::name)
//                                .collect(Collectors.joining(", "))
//                );

                if(ex.getSupportedMethods() != null) {
                    for(String methods:ex.getSupportedMethods()){
                        supportedMethods.append(methods);
                    }
                }
            }

            ErrorResponse errorResponse = new ErrorResponse(
                    LocalDateTime.now(),
                    HttpStatus.METHOD_NOT_ALLOWED.value(),
                    HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase(),
                    "Method not allowed" + supportedMethods,
                    request.getDescription(false)
            );

            return new ResponseEntity<>(errorResponse, HttpStatus.METHOD_NOT_ALLOWED);
        }

}
