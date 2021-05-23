package com.ssu.archive.service;

import com.ssu.archive.dao.ArticleDao;
import com.ssu.archive.entity.Article;

import java.util.List;

public class ArticleLogic {

    private final ArticleDao articleDao;

    public ArticleLogic (ArticleDao articleDao)  {
        this.articleDao = articleDao;
    }

    public Article getById(int id) throws Exception{ return articleDao.getById(id); }

    public void add(Article article) {  articleDao.add(article); }

    public void update(Article article){  articleDao.update(article); }

    public void delete(Article article){ articleDao.delete(article); }

    public List<Article> getAll() { return articleDao.getAll(); }


}
