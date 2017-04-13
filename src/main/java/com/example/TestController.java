package com.example;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Renato Soppelsa
 * 2017
 */
@RestController
@RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController {


    @RequestMapping(path = "get")
    public String get(){
        return "ok";
    }


    @RequestMapping(path = "sec")
    @PreAuthorize("checkPolicy('EDIT')")
    public String sec(){
        return "sec ok";
    }


}
