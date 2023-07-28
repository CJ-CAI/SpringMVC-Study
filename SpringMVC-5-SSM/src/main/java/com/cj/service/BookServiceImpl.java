package com.cj.service;

import com.cj.dao.BookMapper;
import com.cj.pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService{
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public List<Books> get_Books() {
        return bookMapper.get_Books();
    }

    @Override
    public int add_Books(Books books) {
        return bookMapper.add_Books(books);
    }

    @Override
    public int delete_Books(int bookID) {
        return bookMapper.delete_Books(bookID);
    }

    @Override
    public Books query_Books(String name) {
        return bookMapper.query_Books(name);
    }

    @Override
    public int update_Books(Books books) {
        return bookMapper.update_Books(books);
    }


}
