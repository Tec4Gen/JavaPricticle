package com.ssu.archive.service;

import com.ssu.archive.dao.BookDao;
import com.ssu.archive.entity.Book;

import java.util.List;

public class BookLogic {

    private final BookDao bookDao;

    public BookLogic (BookDao bookDao)  {
        this.bookDao = bookDao;
    }

    public Book getById(int id) { return bookDao.getById(id); }

    public boolean add(Book book) { return bookDao.add(book); }

    public boolean update(Book book){ return bookDao.update(book); }

    public boolean delete(int id){ return bookDao.delete(id); }

    public List<Book> getAll() { return bookDao.getAll(); }
}
