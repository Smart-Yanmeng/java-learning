package com.springboottest.springboot01.dao;

import com.springboottest.springboot01.entity.Classes;

public interface IUserDao {

  Classes findById(String id);

  int insertClasses(Classes clazz);
}
