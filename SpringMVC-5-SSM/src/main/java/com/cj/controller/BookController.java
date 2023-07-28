package com.cj.controller;


import com.alibaba.fastjson2.JSON;
import com.cj.pojo.Books;
import com.cj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
@Controller
public class BookController {
    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    @RequestMapping("/books/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/books/doLogin")
    public String doLogin(String name, String pwd, HttpSession httpSession,Model model){
        System.out.println(name+pwd);
        if (name.equals("admin")&&pwd.equals("admin"))
            {
                httpSession.setAttribute("name",name);
                httpSession.setAttribute("pwd",pwd);
                return "books";
            }

        else {
            model.addAttribute("flag",false);
            return "login";
        }
    }

    @RequestMapping("/books")
    public String get_Books(Model model){
        List<Books> booksList=bookService.get_Books();
        model.addAttribute("bookList",booksList);
        return "books";
    }

    @RequestMapping("/books/delete/{bookID}")
    public String delete(@PathVariable int bookID, Model model){
       int flag=bookService.delete_Books(bookID);
       return "forward:/books";
    }

    @RequestMapping("/books/Update")
    public String update(Books books, Model model){
        System.out.println(books.toString());
        int flag=bookService.update_Books(books);
        return "forward:/books";
    }
    @RequestMapping("/books/toUpdate/{bookID}/{bookName}/{bookCounts}/{detail}")
    public String toUpdate(@PathVariable int bookID,@PathVariable String bookName,@PathVariable int bookCounts,@PathVariable String detail,Model model){
        model.addAttribute("bookID",bookID);
        model.addAttribute("bookName",bookName);
        model.addAttribute("bookCounts",bookCounts);
        model.addAttribute("detail",detail);
        return "update_book";
    }

    @RequestMapping("/books/Add")
    public String add(Books books,Model model){
        int flag=bookService.add_Books(books);
        return "forward:/books";
    }
    @RequestMapping("/books/toAdd")
    public String toAdd(){
        return "add_book";
    }

    @RequestMapping("/books/search/")
    public String query_book(String name,Model model){

        System.out.println(name);
        List<Books> booksList=new ArrayList<>();
        booksList.add(bookService.query_Books(name));
        model.addAttribute("bookList",booksList);
        return "books";
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
