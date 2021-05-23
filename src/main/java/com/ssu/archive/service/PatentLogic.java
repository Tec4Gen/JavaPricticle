package com.ssu.archive.service;

import com.ssu.archive.dao.PatentDao;
import com.ssu.archive.entity.Patent;

import java.util.List;

public class PatentLogic {
    private final PatentDao patentDao;

    public PatentLogic (PatentDao paperDao)  {
        this.patentDao = paperDao;
    }

    public Patent getById(int id) throws Exception { return patentDao.getById(id); }

    public void add(Patent newspaper) { patentDao.add(newspaper); }

    public void update(Patent newspaper){ patentDao.update(newspaper); }

    public void delete(Patent newspaper){ patentDao.delete(newspaper); }

    public List<Patent> getAll() { return patentDao.getAll(); }
}
