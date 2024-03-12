package com.mybatis.dao;

import com.mybatis.entity.Clazz;

import java.util.List;

public interface IClassDao {
  Clazz selectClass();

  Clazz selectClassById(String classId);

  Clazz selectClassByClass(Clazz clazz);

  List<Clazz> selectClassByClassName(Clazz clazz);

  int save(Clazz clazz);

  int deleteById(String classId);

  int updateById(Clazz clazz);
}
