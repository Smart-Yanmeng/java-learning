package com.mashang.xiaomishopping.dao;

import com.mashang.xiaomishopping.entity.BHotProductEntity;
import com.mashang.xiaomishopping.entity.BProductEntity;
import com.mashang.xiaomishopping.entity.BProductInfoEntity;
import com.mashang.xiaomishopping.vo.product.ProductQueryListVo;

import java.util.List;

public interface IProductDao {

  // 查询商品列表
  List<BProductEntity> selectProductListByCondition(ProductQueryListVo vo);

  // 查询热门商品列表
  List<BHotProductEntity> selectHotProductListByCondition(Long categoryId);

  // 查询商品详情
  BProductInfoEntity selectProductByCondition(Long productId);

}
