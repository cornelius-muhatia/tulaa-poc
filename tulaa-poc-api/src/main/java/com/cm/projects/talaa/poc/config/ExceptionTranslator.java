/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cm.projects.talaa.poc.config;

import com.cm.projects.talaa.poc.utils.ResponseWrapper;
import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * Used to translate global exceptions caught from the application to more presentable format
 * @author Cornelius M
 */
@ControllerAdvice
public class ExceptionTranslator {
    
    private final Logger log;

    public ExceptionTranslator() {
        this.log = LoggerFactory.getLogger(this.getClass());
    }
    /**
     * Used to translate validation errors
     * @param ex
     * @return 
     */
    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseWrapper> validationException(org.springframework.web.bind.MethodArgumentNotValidException ex) {
        log.error("Validation errors occurred", ex);
        ResponseWrapper response = new ResponseWrapper();
        response.setCode(400);
        response.setMessage("Sorry validation errors occurred");
        response.setData(this.getFieldMapErrors(ex.getBindingResult()));
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }
    /**
     * Used to translate validation errors
     * @param ex
     * @return 
     */
    @ExceptionHandler(org.springframework.validation.BindException.class)
    public ResponseEntity<ResponseWrapper> validationException(org.springframework.validation.BindException ex) {
        log.error("Validation errors occurred", ex);
        ResponseWrapper response = new ResponseWrapper();
        response.setCode(400);
        response.setMessage("Sorry validation errors occurred");
        response.setData(this.getFieldMapErrors(ex.getBindingResult()));
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }
    
   /**
    * Used to translate bad request for missing request parameters
    * @param ex
    * @return 
    */
     @ExceptionHandler(org.springframework.web.bind.MissingServletRequestParameterException.class)
    public ResponseEntity<ResponseWrapper> processSpringValidationError(org.springframework.web.bind.MissingServletRequestParameterException ex) {
        log.error("Encountered missing parameter exception", ex);
        ResponseWrapper response = new ResponseWrapper();
        response.setCode(400);
        response.setData(ex.getMessage());
        response.setMessage("Missing request parameters");
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }
    /**
     * Used to handle general exceptions 
     * @param ex
     * @param request
     * @return 
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ResponseWrapper> handleAllExceptions(Exception ex, WebRequest request) {
        log.error("Caught general exception", ex);
        ResponseWrapper response = new ResponseWrapper(500, "Sorry internal server request occured if the error persists please let us know", null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    /**
     * Used to wrapper validation errors in a map
     * @param validation
     * @return 
     */
    private Map<String, String> getFieldMapErrors(BindingResult validation) {
        return validation.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
    }

}
