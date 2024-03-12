package com.mashang.xiaomishopping.dao;

import com.mashang.xiaomishopping.entity.BCategoryEntity;
import com.mashang.xiaomishopping.entity.BHotProductCategoryEntity;

import java.util.List;

public interface ICategoryDao {

  // 查询商品分类列表
  List<BCategoryEntity> selectCategoryListByCondition(BCategoryEntity category);

  // 查询热门商品分类列表
  List<BHotProductCategoryEntity> selectHotProductCategoryList();

}
