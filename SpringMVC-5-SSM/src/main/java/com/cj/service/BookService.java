package com.cj.service;

import com.cj.pojo.Books;

import java.util.List;

public interface BookService {
    List<Books> get_Books();

    int add_Books(Books books);

    int delete_Books(int id);

    Books query_Books(String name);

    int update_Books(Books books);
}
