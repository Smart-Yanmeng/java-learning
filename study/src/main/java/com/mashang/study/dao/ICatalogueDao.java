package com.mashang.study.dao;

import com.mashang.study.entity.BCatalogueEntity;

import java.util.List;

public interface ICatalogueDao {

  List<BCatalogueEntity> QueryCatalogueInfoList();
}
