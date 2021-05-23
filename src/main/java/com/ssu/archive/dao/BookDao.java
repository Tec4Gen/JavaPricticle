package com.ssu.archive.dao;

import com.ssu.archive.entity.Book;

import java.util.List;

public class BookDao extends Dao<Book> {
    public BookDao () {
        super(Book.class);
    }
}
