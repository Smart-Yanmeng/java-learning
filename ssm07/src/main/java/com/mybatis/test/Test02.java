package com.mybatis.test;

import com.mybatis.dao.IClassDao;
import com.mybatis.entity.Clazz;
import com.mybatis.view.ClazzView;
import com.mybatis.view.StudentView;
import com.mybatis.vo.ClassQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class Test02 {
  public static void main(String[] args) throws IOException {
    InputStream in = Resources.getResourceAsStream("myBatis-config.xml");
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory factory = builder.build(in);
    SqlSession sqlSession = factory.openSession();
    IClassDao classDao = sqlSession.getMapper(IClassDao.class);

//    List<Clazz> classList = classDao.selectClassListByCondition();
//
//    for (Clazz clazz : classList) {
//      System.out.println(clazz);
//    }

//    List<ClazzView> clazzViews = classDao.selectClassWithStu();
//    for (ClazzView classView : clazzViews) {
//      System.out.println(classView);
//    }

//    List<StudentView> studentViews = classDao.selectStuWithClass();
//    for (StudentView studentView : studentViews) {
//      System.out.println(studentView);
//    }

//    ClassQueryVo vo = new ClassQueryVo();
//    vo.setIds(Arrays.asList("16597267904311", "16597267951722", "16597268119526"));
//    List<Clazz> classes = classDao.selectByIdList(vo);
//    for (Clazz clazz : classes) {
//      System.out.println(clazz);
//    }

    classDao.selectById("16597268119526");

  }
}
