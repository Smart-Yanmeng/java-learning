package com.mashang.xiaomishopping.service;

import cn.hutool.core.date.DateUtil;
import com.mashang.xiaomishopping.dao.ICollectDao;
import com.mashang.xiaomishopping.entity.BCollectEntity;
import com.mashang.xiaomishopping.view.collect.CollectView;
import com.mashang.xiaomishopping.vo.collect.CollectProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollectService {

  @Autowired
  private ICollectDao collectDao;

  public List<CollectView> collectList(Long userId) {

    List<BCollectEntity> collectList = collectDao.queryCollectProductInfoList(userId);

    return collectList.stream().map(s -> new CollectView().transfer(s)).collect(Collectors.toList());
  }

  @Transactional(rollbackFor = Exception.class)
  public void createAndDeleteCollect(Long userId, Long productId) {

    if (collectDao.selectProductIsCollectByCondition(userId, productId) == 1) {

      collectDao.deleteCollectProduct(userId, productId);
    } else {
      CollectProductVo collectProductVo = new CollectProductVo().transfer(collectDao.queryProductByCondition(productId));
      collectProductVo.setUserId(userId);
      collectProductVo.setCreateTime(DateUtil.now());

      collectDao.createCollectProduct(collectProductVo);
    }
  }

}
