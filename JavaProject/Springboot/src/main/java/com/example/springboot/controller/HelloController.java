package com.example.springboot.controller;

import com.example.springboot.pojo.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class HelloController {

    @Autowired
    Pet pet;

    @RequestMapping({"/", "/index"})
    public String index(Model model) {
//        Pet pet = new Pet();
//        pet.setAge(20);
//        pet.setName("liming");
        model.addAttribute("pet", pet);
        return "index";
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("hello", "Hello");
        return "hello";
    }


    @GetMapping("/date")
    public String date(Model model) {
        model.addAttribute("today", new Date());
        return "date";
    }
}
