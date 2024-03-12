package com.mashang.xiaomishopping.dao;

import com.mashang.xiaomishopping.entity.BCarouselEntity;

import java.util.List;

public interface ICarouselDao {

  // 查询轮播图列表
  List<BCarouselEntity> selectCarouselList();

}
