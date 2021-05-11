package com.ssu.archive.service;

import com.ssu.archive.dao.PatentDao;
import com.ssu.archive.entity.Patent;

import java.util.List;

public class PatentLogic {
    private final PatentDao patentDao;

    public PatentLogic (PatentDao paperDao)  {
        this.patentDao = paperDao;
    }

    public Patent getById(int id) { return patentDao.getById(id); }

    public boolean add(Patent newspaper) { return patentDao.add(newspaper); }

    public boolean update(Patent newspaper){ return patentDao.update(newspaper); }

    public boolean delete(int id){ return patentDao.delete(id); }

    public List<Patent> getAll() { return patentDao.getAll(); }
}
