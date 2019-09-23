package com.ki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
@PropertySource("classpath:test.properties")
public class HelloController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/hello")
    public String test1(Model model, @Value("${test.item1.text}") String text, Locale locale) {
        String i18nString = messageSource.getMessage("msg.test.item1", null, locale);
        System.out.println(i18nString);
        model.addAttribute("receiveMsg", text + i18nString);
        model.addAttribute("locale", locale.toString());
        return "sample";
    }
}
