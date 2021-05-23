package com.ssu.archive.dao;

import com.ssu.archive.entity.Newspaper;

import javax.lang.model.element.NestingKind;
import java.util.List;

public class NewspaperDao extends Dao<Newspaper>{
   public NewspaperDao() {
       super(Newspaper.class);
   }
}
