/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cm.projects.talaa.poc.services;

import java.util.Stack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cornelius M
 */
@Service
public class StewardServiceTemplate implements StewardService {

    private final Logger log;

    public StewardServiceTemplate() {
        this.log = LoggerFactory.getLogger(this.getClass());
    }
    /**
     * Reverses a string while maintaining special character position by traversing from both ends of a string
     * @param input
     * @return reversed string
     */
    @Override
    public String reverseString(String input) {
        char str[] = input.toCharArray();

        int r = str.length - 1, l = 0;

        while (l < r) {
            // Ignore special characters
            if (!Character.isAlphabetic(str[l])) {
                l++;
            } else if (!Character.isAlphabetic(str[r])) {
                r--;
            } else {
                char tmp = str[l];
                str[l] = str[r];
                str[r] = tmp;
                l++;
                r--;
            }
        }
        return new String(str);
    }

    @Override
    public boolean isTripletArray(int[] input) {
        int n = input.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int x = input[i] * input[i], y = input[j] * input[j], z = input[k] * input[k];

                    if (x == y + z || y == x + z || z == x + y) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean compileCodeBlock(String input) {
        char arr[] = input.toCharArray();
        Stack<Character> set = new Stack();
        for (Character ch : arr) {
            if (null != ch) switch (ch) {
                case '{':
                case '[':
                case '(':
                    set.push(ch);
                    break;
                case ']':
                    if (set.isEmpty() || set.peek() != '[') {
                        return false;
                    }   set.pop();
                    break;
                case ')':
                    if (set.isEmpty() || set.peek() != '(') {
                        return false;
                    }   set.pop();
                    break;
                case '}':
                    if (set.isEmpty() || set.peek() != '{') {
                        return false;
                    }   set.pop();
                    break;
                default:
                    break;
            }
        }
        return set.isEmpty();
    }

}
