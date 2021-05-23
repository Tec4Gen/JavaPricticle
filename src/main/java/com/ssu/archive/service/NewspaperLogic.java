package com.ssu.archive.service;

import com.ssu.archive.dao.NewspaperDao;
import com.ssu.archive.entity.Newspaper;

import java.util.List;

public class NewspaperLogic {

    private final NewspaperDao newspaperDao;

    public NewspaperLogic (NewspaperDao newspaper)  {
        this.newspaperDao = newspaper;
    }


    public Newspaper getById(int id) throws Exception { return newspaperDao.getById(id); }

    public void add(Newspaper newspaper) { newspaperDao.add(newspaper); }

    public void update(Newspaper newspaper){ newspaperDao.update(newspaper); }

    public void delete(Newspaper newspaper){ newspaperDao.delete(newspaper); }

    public List<Newspaper> getAll() { return newspaperDao.getAll(); }
}
