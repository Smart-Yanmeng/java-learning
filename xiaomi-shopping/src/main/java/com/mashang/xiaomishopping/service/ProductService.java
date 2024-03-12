package com.mashang.xiaomishopping.service;

import com.mashang.xiaomishopping.dao.ICollectDao;
import com.mashang.xiaomishopping.dao.IProductDao;
import com.mashang.xiaomishopping.entity.BProductEntity;
import com.mashang.xiaomishopping.view.product.ProductListView;
import com.mashang.xiaomishopping.vo.product.ProductQueryListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

  @Autowired
  private IProductDao productDao;

  public List<ProductListView> productList(ProductQueryListVo vo) {

    List<BProductEntity> productList = productDao.selectProductListByCondition(vo);

    return productList.stream().map(s -> new ProductListView().transfer(s)).collect(Collectors.toList());
  }

}
