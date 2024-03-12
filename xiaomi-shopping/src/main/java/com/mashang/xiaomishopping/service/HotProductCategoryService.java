package com.mashang.xiaomishopping.service;

import com.mashang.xiaomishopping.dao.ICategoryDao;
import com.mashang.xiaomishopping.dao.IProductDao;
import com.mashang.xiaomishopping.entity.BCategoryEntity;
import com.mashang.xiaomishopping.entity.BHotProductCategoryEntity;
import com.mashang.xiaomishopping.entity.BHotProductEntity;
import com.mashang.xiaomishopping.view.product.HotProductCategoryView;
import com.mashang.xiaomishopping.view.product.HotProductListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotProductCategoryService {

  @Autowired
  private ICategoryDao categoryDao;

  @Autowired
  private IProductDao productDao;

  public List<HotProductCategoryView<HotProductListView>> hotProductCategoryList() {
    List<BHotProductCategoryEntity> hotProductCategoryEntities = categoryDao.selectHotProductCategoryList();
    List<HotProductCategoryView<HotProductListView>> viewList = new ArrayList<>();

    for (BHotProductCategoryEntity hotProductCategoryEntity : hotProductCategoryEntities) {
      List<BHotProductEntity> hotProductEntities = productDao.selectHotProductListByCondition(hotProductCategoryEntity.getCategoryId());
      HotProductCategoryView<HotProductListView> view = new HotProductCategoryView<HotProductListView>().transfer(hotProductCategoryEntity);
      view.setProducts(hotProductEntities.stream().map(s -> new HotProductListView().transfer(s)).collect(Collectors.toList()));
      viewList.add(view);

    }

    return viewList;
  }

}
