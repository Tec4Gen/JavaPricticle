package com.ssu.archive.service;

import com.ssu.archive.dao.ArticleDao;
import com.ssu.archive.dao.AuthorDao;
import com.ssu.archive.entity.Article;
import com.ssu.archive.entity.Author;

import java.util.List;

public class AuthorLogic {

    private final AuthorDao authorDao;

    public AuthorLogic (AuthorDao authorDao)  {
        this.authorDao = authorDao;
    }

    public Author getById(int id) { return authorDao.getById(id); }

    public boolean add(Author author) { return authorDao.add(author); }

    public boolean update(Author author){ return authorDao.update(author); }

    public boolean delete(int id){ return authorDao.delete(id); }

    public List<Author> getAll() { return authorDao.getAll(); }
}
