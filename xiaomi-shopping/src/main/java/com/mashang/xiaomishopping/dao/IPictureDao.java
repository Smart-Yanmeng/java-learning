package com.mashang.xiaomishopping.dao;

import com.mashang.xiaomishopping.entity.BPictureEntity;

import java.util.List;

public interface IPictureDao {

  // 查询商品图片列表
  List<BPictureEntity> selectPictureByCondition(Long productId);

}
