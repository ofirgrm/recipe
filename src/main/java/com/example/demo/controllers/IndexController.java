package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    // return the index.html for thymeleaf
    @RequestMapping({"", "/", "index"})
    public String getIndexPage() {
        System.out.println("test!!!");

        return "index";
    }

}
