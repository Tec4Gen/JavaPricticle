package com.ssu.archive.service;

import com.ssu.archive.dao.ArticleDao;
import com.ssu.archive.entity.Article;

import java.util.List;

public class ArticleLogic {

    private final ArticleDao articleDao;

    public ArticleLogic (ArticleDao articleDao)  {
        this.articleDao = articleDao;
    }

    public Article getById(int id) { return articleDao.getById(id); }

    public boolean add(Article article) { return articleDao.add(article); }

    public boolean update(Article article){ return articleDao.update(article); }

    public boolean delete(int id){ return articleDao.delete(id); }

    public List<Article> getAll() { return articleDao.getAll(); }


}
