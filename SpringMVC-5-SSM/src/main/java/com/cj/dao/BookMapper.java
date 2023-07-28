package com.cj.dao;

import com.cj.pojo.Books;

import java.util.List;

public interface BookMapper {
    List<Books> get_Books();

    int add_Books(Books books);

    int delete_Books(int bookID);

    Books query_Books(String name);

    int update_Books(Books books);
}
