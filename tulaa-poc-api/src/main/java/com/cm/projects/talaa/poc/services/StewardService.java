/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cm.projects.talaa.poc.services;

/**
 *
 * @author Cornelius M
 */
public interface StewardService {
    /**
     * Used to reverse a string while maintaining special char positions
     * @param input
     * @return reversed string
     */
    public String reverseString(String input);
    /**
     * Used to determine if an array is triplex
     * @param input
     * @return 
     */
    public boolean isTripletArray(int[] input);
    /**
     * Used to validate if a string has closed brackets
     * @param input
     * @return 
     */
    public boolean compileCodeBlock(String input);

}
