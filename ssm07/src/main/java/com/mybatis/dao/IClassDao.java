package com.mybatis.dao;

import com.mybatis.entity.Clazz;
import com.mybatis.view.ClazzView;
import com.mybatis.view.StudentView;
import com.mybatis.vo.ClassQueryVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IClassDao {
  Clazz selectClass();

  Clazz selectClassById(String classId);

  Clazz selectClassByClass(Clazz clazz);

  List<Clazz> selectClassByClassName(Clazz clazz);

  int save(Clazz clazz);

  int deleteById(String classId);

  int updateById(Clazz clazz);

  List<Clazz> selectClassListByCondition();

  List<ClazzView> selectClassWithStu();

  List<StudentView> selectStuWithClass();

  List<Clazz> selectByCondition(Clazz clazz);

  List<Clazz> selectByIdList(ClassQueryVo vo);

  @Select("select * from t_class where class_id = #{id}")
  Clazz selectById(String id);

}
