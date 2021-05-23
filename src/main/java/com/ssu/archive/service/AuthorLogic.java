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

    public Author getById(int id) throws Exception { return authorDao.getById(id); }

    public void add(Author author) { authorDao.add(author); }

    public void update(Author author){ authorDao.update(author); }

    public void delete(Author author){ authorDao.delete(author); }

    public List<Author> getAll() { return authorDao.getAll(); }
}
