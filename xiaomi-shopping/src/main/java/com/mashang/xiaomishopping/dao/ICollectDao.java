package com.mashang.xiaomishopping.dao;

import com.mashang.xiaomishopping.entity.BCollectEntity;
import com.mashang.xiaomishopping.entity.BProductEntity;
import com.mashang.xiaomishopping.vo.collect.CollectProductVo;

import java.util.List;

public interface ICollectDao {

  // 查询收藏商品信息
  List<BCollectEntity> queryCollectProductInfoList(Long userId);

  // 添加收藏
  void createCollectProduct(CollectProductVo vo);

  // 删除收藏
  void deleteCollectProduct(Long userId, Long productId);

  // 查询商品是否被收藏
  Integer selectProductIsCollectByCondition(Long userId, Long productId);

  // 查询需要被收藏的商品信息
  BProductEntity queryProductByCondition(Long productId);

}
