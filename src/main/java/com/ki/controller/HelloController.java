package com.ki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String test1(Model model) {
        model.addAttribute("receiveMsg", "This is Good Demo.");
        return "sample";
    }
}
