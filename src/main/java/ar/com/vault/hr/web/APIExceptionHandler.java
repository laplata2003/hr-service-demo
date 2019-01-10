package ar.com.vault.hr.web;

import java.util.Date;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import ar.com.vault.hr.exception.EntityNotFoundException;

/**
 * Exception handler for custom message format and HTTP code in case of an entity is not found.
 * 
 * @author Gaston Napoli
 *
 */
@ControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorDetails processEntityNotFound(EntityNotFoundException ex, WebRequest request) {
        return new ErrorDetails(new Date(), ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDetails processValidationError(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        return new ErrorDetails(new Date(), result.getAllErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDetails processConstraintViolation(ConstraintViolationException ex, WebRequest request) {
        return new ErrorDetails(new Date(), ex.getMessage());
    }
    
    
}
