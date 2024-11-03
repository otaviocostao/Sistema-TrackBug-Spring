package com.trackbug.trackbug.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

    @GetMapping("/home")
    public String paginaHome(){
        return "index";
    }


}
