/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cm.projects.talaa.poc.entities.wrappers;

import java.util.Arrays;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Cornelius M
 */
public class TriplexInput {
    
    @NotNull
    @Size(min = 1, max = 1000)
    private int[] input;

    public TriplexInput() {
    }

    public int[] getInput() {
        return input;
    }

    public void setInput(int[] input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "TriplexInput{" + "input=" + Arrays.toString(this.input) + '}';
    }
    
    
    

}
