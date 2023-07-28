package com.cj.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Hello_controller implements Controller{

    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws Exception {
        ModelAndView mv=new ModelAndView();
        mv.addObject("MSG","to be or not to be,this is a question");
        mv.setViewName("hello");
        return mv;
    }
}
