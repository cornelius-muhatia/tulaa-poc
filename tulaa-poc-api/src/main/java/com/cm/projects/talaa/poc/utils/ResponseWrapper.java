/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cm.projects.talaa.poc.utils;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Cornelius M
 */
public class ResponseWrapper <T> implements Serializable{    
    private int code;
    private String message;
    private T data;
    private Long timestamp;
    
    public static ResponseWrapper successWrapper(Object data){
        return new ResponseWrapper(200, "Request was successful", data);
    }
    
    
    public static ResponseWrapper badRequestWrapper(Object data){
        return new ResponseWrapper(400, "Sorry bad request please check your input before trying again", data);
    }
    
    public ResponseWrapper(){
        this.code = 200;
        this.message = "Request was successful";
        this.timestamp = new Date().getTime();
    }
    
    public ResponseWrapper(int code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = new Date().getTime();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
      
}