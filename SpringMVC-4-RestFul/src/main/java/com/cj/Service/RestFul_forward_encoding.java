package com.cj.Service;

import com.cj.pojo.User;
import com.cj.utils.jackson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class RestFul_forward_encoding {
//===================================================RestFul风格测试==================================================================
    @RequestMapping("/")
    public String test(Model model){
        model.addAttribute("MSG","I'm Server");
        return "login";
    }

    @RequestMapping(value = "/son/{a}/{b}",method =  {RequestMethod.GET})
    public String test(@PathVariable int a,@PathVariable int b,Model model){
        int sum=a+b;
        model.addAttribute("MSG",Integer.toString(sum));
        model.addAttribute(a);
        model.addAttribute(b);
        return "RestFul";
    }

//    ===================================================Servlet重定向，转发测试==================================================================
    @GetMapping("/t1")//Servlet响应测试
    public void test1(HttpServletRequest req, HttpServletResponse rsp) throws IOException {

        rsp.getWriter().println("hello,client.this is t1 response");
    }

    @GetMapping("/t2")//Servlet重定向测试
    public void test2(HttpServletRequest req, HttpServletResponse rsp) throws IOException {

        rsp.sendRedirect("/test.jsp");
    }

    @GetMapping("/t3")//Servlet转发参数测试
    public void test3(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        req.setAttribute("MSG","hello,client,this is Server t3 Controller forward Test/n");
        req.getRequestDispatcher("/test.jsp").forward(req,rsp);
    }
    @GetMapping("/t4")//ModelAndView转发参数测试
    public ModelAndView test4(HttpServletRequest req, HttpServletResponse rsp,ModelAndView modelAndView){
        modelAndView.addObject("MSG","this is a ModelAndView测试");
        modelAndView.setViewName("test");
        return modelAndView;
    }


//    =================================MVC转发重定向测试，注意关闭视图解释器测试==================================================
    @GetMapping("t1_mvc")
    public String mvc_test1(){
        return "/test.jsp";
    }

    @GetMapping("t2_mvc")
    public String mvc_test2(){
        return "forward:/test.jsp";
    }

    @GetMapping("t3_mvc")
    public String mvc_test3(){
        return "redirect:/test.jsp";
    }
//================================================数据处理测试================================================================
    @GetMapping("/p1")
    public String parameter_t1(@RequestParam("name") String name,Model model){
        model.addAttribute("MSG",name);
        return "test";
}

    @GetMapping("/p2")
    public String parameter_t2(String name,Model model){
        model.addAttribute("MSG",name);
        return "test";
    }

    @GetMapping("/p3")
    public String parameter_t2(User user,Model model){
        model.addAttribute("MSG",user.toString());
        return "test";
    }
//=================================================乱码测试================================================================
    @PostMapping("/e1")
    public String Encoding(String str,Model model) {
        model.addAttribute("str",str);
        System.out.println(str);
        return "test";
    }

}
