package com.mashang.study.service;

import com.mashang.study.dao.ICatalogueDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogueService {

  @Autowired
  private ICatalogueDao catalogueDao;



}
