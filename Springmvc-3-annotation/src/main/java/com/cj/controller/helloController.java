package com.cj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {
    @RequestMapping("/")
    public String sayHello(Model model){
        model.addAttribute("MSG","hello,Spring-MVC");
        return "hello";
    }
    @ResponseBody
    @RequestMapping("/word")
    public String users(Model model){
        return "to be or not to be, this a question.";
    }
    @ResponseBody
    @RequestMapping("/right")
    public String right(Model model){
        return "It is never wrong to do the right thing";
    }
}
