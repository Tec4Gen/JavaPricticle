package com.ssu.archive.dao;

import com.ssu.archive.entity.Patent;

import java.util.List;

public class PatentDao extends Dao<Patent>{
   public PatentDao() {
       super(Patent.class);
   }
}
