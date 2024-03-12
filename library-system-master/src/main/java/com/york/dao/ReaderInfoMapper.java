package com.york.dao;

import com.york.po.ReaderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReaderInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(ReaderInfo record);

    int insertSelective(ReaderInfo record);

    ReaderInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReaderInfo record);

    int updateByPrimaryKey(ReaderInfo record);

    /**
     * 查询所有记录信息
     */
    List<ReaderInfo> queryAllReaderInfo(ReaderInfo readerInfo);

    /**
     * 根据用户名和密码查询用户信息
     */
    ReaderInfo queryUserInfoByNameAndPassword(@Param("username") String username, @Param("password") String password);
}
