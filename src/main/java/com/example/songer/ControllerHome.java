package com.example.songer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

@Controller
public class ControllerHome {

    @GetMapping("/")
    public String getHome(){
        return "splash.html";
    }

    @GetMapping("/hello")
    public String getHello(){
        return "hello.html";
    }

    @GetMapping("/capitalize/{hello}")
    public String getCapitalize1(Model model, @PathVariable String hello ){
        model.addAttribute("hello" , hello.toUpperCase(Locale.ROOT));
        return "capitalize.html";
    }





}
