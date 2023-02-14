package com.invest.ZGInvest.resources.exceptions;

import com.invest.ZGInvest.services.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    private Integer status = HttpStatus.NOT_FOUND.value();
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandarError> entityNotFound(EntityNotFoundException e, HttpServletRequest request){
        StandarError err = new StandarError();
        err.setTimestamp(Instant.now());
        err.setStatus(status);
        err.setError("Resource not found");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
