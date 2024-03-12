package com.mashang.xiaomishopping.service;

import com.mashang.xiaomishopping.dao.IAreaDao;
import com.mashang.xiaomishopping.entity.BAreaEntity;
import com.mashang.xiaomishopping.view.area.AreaListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AreaService {

  @Autowired
  private IAreaDao areaDao;

  public List<AreaListView> queryArea(Integer pid) {

    List<BAreaEntity> areaList = areaDao.queryAreaByCondition(pid);

    return areaList.stream().map(s -> new AreaListView().transfer(s)).collect(Collectors.toList());
  }

}
