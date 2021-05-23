package com.ssu.archive.service;

import com.ssu.archive.dao.BookDao;
import com.ssu.archive.entity.Book;

import java.util.List;

public class BookLogic {

    private final BookDao bookDao;

    public BookLogic (BookDao bookDao)  {
        this.bookDao = bookDao;
    }

    public Book getById(int id)  throws Exception  { return bookDao.getById(id); }

    public void add(Book book) {  bookDao.add(book); }

    public void update(Book book){  bookDao.update(book); }

    public void delete(Book book){ bookDao.delete(book); }

    public List<Book> getAll() { return bookDao.getAll(); }
}
