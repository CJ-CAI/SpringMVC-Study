package com.cj.controller;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class interceptor_1 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("uri: " + request.getRequestURI());
        HttpSession httpSession=request.getSession();
        String name=(String)httpSession.getAttribute("name");
        if (request.getRequestURI().indexOf("login")!=-1)
        {
            System.out.println("放通url"+request.getRequestURI());
            return true;
        }
        if (request.getRequestURI().indexOf("doLogin")!=-1)
        {
            System.out.println("放通url"+request.getRequestURI());
            return true;
        }
        System.out.println(name);
        if (name!=null)
            return true;
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
