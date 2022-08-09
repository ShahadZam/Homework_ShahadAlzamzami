package com.example.springday1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class WelcomeController {

    @GetMapping("/hey")
    public String hey(){
        return "Hey from spring";
    }

    @GetMapping("/bye")
    public String bye(){
        return "Bye";
    }

    @GetMapping("/check/status")
    public String checkStatus(){
        return "Everything is OK";
    }

    @GetMapping("/health")
    public String health() {
        return "Server health is up and running";
    }




}
