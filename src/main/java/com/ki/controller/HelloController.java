package com.ki.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@PropertySource("classpath:test.properties")
public class HelloController {

    @RequestMapping("/hello")
    public String test1(Model model, @Value("${test.item1.text}") String text) {
        System.out.println(">>>" + text);
        model.addAttribute("receiveMsg", text);
        return "sample";
    }
}
