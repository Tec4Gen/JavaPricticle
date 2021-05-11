package com.ssu.archive.dao;

import com.ssu.archive.entity.Article;

import java.util.List;


public class ArticleDao {
    public Article getById(int id) { return new Article(); }

    public boolean add(Article article) { return false; }

    public boolean update(Article article){ return false;}

    public boolean delete(int id){ return false; }

    public List<Article> getAll() { return null; }
}
