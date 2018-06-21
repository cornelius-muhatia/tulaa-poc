/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cm.projects.talaa.poc.entities.wrappers;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Cornelius M
 */
public class StringInput {
    
    @Size(min = 1, max = 2000)
    @NotNull
    private String inputString;

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        if(inputString != null){
            inputString = inputString.trim();
        }
        this.inputString = inputString;
    }

    @Override
    public String toString() {
        return "StringInput{" + "inputString=" + inputString + '}';
    }
    
    

}
