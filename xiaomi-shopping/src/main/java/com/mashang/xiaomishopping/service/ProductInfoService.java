package com.mashang.xiaomishopping.service;

import com.mashang.xiaomishopping.dao.ICollectDao;
import com.mashang.xiaomishopping.dao.IPictureDao;
import com.mashang.xiaomishopping.dao.IProductDao;
import com.mashang.xiaomishopping.entity.BPictureEntity;
import com.mashang.xiaomishopping.entity.BProductInfoEntity;
import com.mashang.xiaomishopping.view.product.PictureListView;
import com.mashang.xiaomishopping.view.product.ProductInfoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductInfoService {

  @Autowired
  private IProductDao productDao;

  @Autowired
  private IPictureDao pictureDao;

  @Autowired
  private ICollectDao collectDao;

  @Transactional(rollbackFor = Exception.class)
  public ProductInfoView<PictureListView> productInfo(Long userId, Long productId) {

    BProductInfoEntity productInfoEntity = productDao.selectProductByCondition(productId);
    ProductInfoView<PictureListView> productInfo = new ProductInfoView<PictureListView>().transfer(productInfoEntity);

    if (collectDao.selectProductIsCollectByCondition(userId, productId) == 1) productInfo.setIsCollect(1);
    else productInfo.setIsCollect(0);

    List<BPictureEntity> pictureEntities = pictureDao.selectPictureByCondition(productId);
    List<PictureListView> pictureList = new ArrayList<>();
    for (BPictureEntity picture : pictureEntities) {
      pictureList.add(new PictureListView().transfer(picture));
    }

    productInfo.setPictures(pictureList);

    System.out.println(productInfo.getIsCollect());

    return productInfo;
  }

}
