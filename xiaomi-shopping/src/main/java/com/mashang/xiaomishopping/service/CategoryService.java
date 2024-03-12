package com.mashang.xiaomishopping.service;

import com.mashang.xiaomishopping.dao.ICategoryDao;
import com.mashang.xiaomishopping.entity.BCategoryEntity;
import com.mashang.xiaomishopping.view.category.CategoryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

  @Autowired
  private ICategoryDao categoryDao;

  public List<CategoryView> categoryList() {

    List<BCategoryEntity> categoryList = categoryDao.selectCategoryListByCondition(new BCategoryEntity());

    return categoryList.stream().map(s -> new CategoryView().transfer(s)).collect(Collectors.toList());
  }

}
