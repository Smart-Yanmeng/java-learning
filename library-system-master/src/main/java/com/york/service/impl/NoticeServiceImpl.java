package com.york.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.york.dao.NoticeMapper;
import com.york.po.Notice;
import com.york.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

    @Resource
    private NoticeMapper noticeMapper;

    @Override
    public PageInfo<Notice> queryAllNotice(Notice notice, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum, limit);
        List<Notice> noticeList = noticeMapper.queryNoticeAll(notice);
        return new PageInfo<>(noticeList);
    }

    @Override
    public void addNotice(Notice notice) {
        noticeMapper.insert(notice);
    }

    @Override
    public Notice queryNoticeById(Integer id) {
        return noticeMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteNoticeByIds(List<String> ids) {
        for (String id : ids) {
            noticeMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
    }
}
