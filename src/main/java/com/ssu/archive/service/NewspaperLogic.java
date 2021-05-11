package com.ssu.archive.service;

import com.ssu.archive.dao.NewspaperDao;
import com.ssu.archive.entity.Newspaper;

import java.util.List;

public class NewspaperLogic {

    private final NewspaperDao newspaperDao;

    public NewspaperLogic (NewspaperDao newspaper)  {
        this.newspaperDao = newspaper;
    }


    public Newspaper getById(int id) { return newspaperDao.getById(id); }

    public boolean add(Newspaper newspaper) { return newspaperDao.add(newspaper); }

    public boolean update(Newspaper newspaper){ return newspaperDao.update(newspaper); }

    public boolean delete(int id){ return newspaperDao.delete(id); }

    public List<Newspaper> getAll() { return newspaperDao.getAll(); }
}
