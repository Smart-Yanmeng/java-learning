package com.mashang.xiaomishopping.service;

import com.mashang.xiaomishopping.dao.ICarouselDao;
import com.mashang.xiaomishopping.entity.BCarouselEntity;
import com.mashang.xiaomishopping.view.carousel.CarouselView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarouselService {

  @Autowired
  private ICarouselDao carouselDao;

  public List<CarouselView> carouselList() {

    List<BCarouselEntity> carouselList = carouselDao.selectCarouselList();

    return carouselList.stream().map(s -> new CarouselView().transfer(s)).collect(Collectors.toList());
  }

}
