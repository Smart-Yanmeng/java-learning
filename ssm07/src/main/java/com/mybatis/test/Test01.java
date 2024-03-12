package com.mybatis.test;

import com.mybatis.dao.IClassDao;
import com.mybatis.entity.Clazz;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test01 {
  public static void main(String[] args) throws IOException {
    // 读取mybatis的配置文件
// 会根据配置生成数据库连接池
// 根据mapper配置，利用反射机制生成对应的代理类
    InputStream in = Resources.getResourceAsStream("myBatis-config.xml");
// 创建一个sqlSessionFactory的创建者
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
// 创建一个sqlSessionFactory
    SqlSessionFactory factory = builder.build(in);
// 创建sqlSession
    SqlSession sqlSession = factory.openSession();
// 生成对应的接口代理类
    IClassDao classDao = sqlSession.getMapper(IClassDao.class);

//    Clazz clazz = classDao.selectClass();
//    System.out.println(clazz);

//    Clazz clazz = classDao.selectClass("16597268031444");
//    System.out.println(clazz);

//    Clazz queryClazz = new Clazz();
//    queryClazz.setClassId("16597268031444");
//    queryClazz.setClassNo("1");
//    queryClazz.setCreateTime("2022-08-06 03:13:23");
//    queryClazz.setName("1");
//    queryClazz.setRemark("1");
//    queryClazz.setType(2);
//    Clazz clazz = classDao.selectClass(queryClazz);
//    System.out.println(clazz);

//    Clazz queryClass = new Clazz();
//    queryClass.setClassId("%1%");
//    List<Clazz> clazzList = classDao.selectClassByClassName(queryClass);
//    for (Clazz clazz : clazzList) {
//      System.out.println(clazz);
//    }

//    Clazz addClazz = new Clazz();
//    addClazz.setClassId("1");
//    addClazz.setClassNo("1");
//    addClazz.setCreateTime("2022-08-06 03:13:23");
//    addClazz.setName("1");
//    addClazz.setRemark("1");
//    addClazz.setType(2);
//    int num = classDao.save(addClazz);
//    System.out.println(num);
//
//    // 事务提交
//    sqlSession.commit();

//    int num = classDao.deleteById("1");
//    System.out.println(num);
//
//    sqlSession.commit();

    Clazz clazz = new Clazz();
    clazz.setClassId("16597267904311");
    clazz.setName("1");
    int num = classDao.updateById(clazz);
    System.out.println(num);

    sqlSession.commit();
  }
}