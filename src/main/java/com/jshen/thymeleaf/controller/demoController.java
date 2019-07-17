package com.jshen.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class demoController {

    @GetMapping("/hello")
    public String sayHello(Model theModel){
        theModel.addAttribute("theDate", new java.util.Date());

        return "helloworld"; // this string must be same as the file in templates (helloworld.html), and inside helloworld.html, it will take theDate and show it on the screen
    }
}
