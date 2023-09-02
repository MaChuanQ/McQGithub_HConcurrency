package com.example.seckill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class demo {
    @GetMapping("/demo")
    public String demo(Model model){
        model.addAttribute("name","123");
        return "demo";
    }
}
