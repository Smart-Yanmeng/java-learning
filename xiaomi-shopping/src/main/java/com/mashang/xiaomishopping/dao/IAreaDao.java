package com.mashang.xiaomishopping.dao;

import com.mashang.xiaomishopping.entity.BAreaEntity;

import java.util.List;

public interface IAreaDao {

  List<BAreaEntity> queryAreaByCondition(Integer pid);

}
