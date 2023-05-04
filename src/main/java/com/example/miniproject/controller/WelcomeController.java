package com.example.miniproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
    @GetMapping("/")
    public ModelAndView index(@RequestParam(name="name") String name) {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("name", name);
        return mav;
    }
}
