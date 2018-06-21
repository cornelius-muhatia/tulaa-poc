/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cm.projects.talaa.poc.resources;

import com.cm.projects.talaa.poc.entities.wrappers.StringInput;
import com.cm.projects.talaa.poc.entities.wrappers.TriplexInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import com.cm.projects.talaa.poc.services.StewardService;
import com.cm.projects.talaa.poc.utils.ResponseWrapper;
import io.swagger.annotations.Api;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Cornelius M
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Api(value = "Main Resource")
public class MainResource {

    private final Logger log;
    private final StewardService sterwardService;

    public MainResource(StewardService sterwardService) {
        this.log = LoggerFactory.getLogger(this.getClass());
        this.sterwardService = sterwardService;
    }

    /**
     * Used to process reverse string request from client requests
     *
     * @param input the input string to be reversed
     * @return {@link ResponseEntity} of the reversed string
     */
    @PostMapping("/reverse-string")
    public ResponseEntity<ResponseWrapper<String>> reverseString(@Valid StringInput input) {
        log.info("Processing reverse string request {}", input.getInputString());
        String output = this.sterwardService.reverseString(input.getInputString());
        return ResponseEntity.ok(ResponseWrapper.successWrapper(output));
    }

    /**
     * Given an array of integers, returns true if there is a triplet
     * <b>i.e.</b> if there is a triplet (a, b, c) that satisfies
     * <i><strong>a<sup>2</sup> + b<sup>2</sup> = c<sup>2</sup></strong></i>
     *
     * @param input
     * @return
     */
    @PostMapping("/validate-triplex")
    public ResponseEntity<ResponseWrapper<Boolean>> isTriplex(@Valid @RequestBody TriplexInput input) {
        log.info("Determining if an array is a triplex {}", input);
        return ResponseEntity.ok(ResponseWrapper.successWrapper(this.sterwardService.isTripletArray(input.getInput())));
    }

    /**
     * Determines if a string of characters '(', ')', '{', '}', '[' and ']' is
     * valid <strong>i.e.</strong> brackets must close in the correct order,
     *
     * @param input
     * @return {@link ResponseWrapper}
     */
    @PostMapping("/compile-blocks")
    public ResponseEntity<ResponseWrapper<Boolean>> compileBlocks(@Valid StringInput input) {
        log.info("Compiling string ({}) to determine if blocks are correctly set", input);
        return ResponseEntity.ok(ResponseWrapper.successWrapper(this.sterwardService.compileCodeBlock(input.getInputString())));
    }

}
