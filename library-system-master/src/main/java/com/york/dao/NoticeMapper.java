package com.york.dao;

import com.york.po.Notice;

import java.util.List;

public interface NoticeMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);

    /**
     * 查询所有公告信息
     */
    List<Notice> queryNoticeAll(Notice notice);

}
