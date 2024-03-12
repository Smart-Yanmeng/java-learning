package com.york.controller;

import com.york.po.BookInfo;
import com.york.service.BookInfoService;
import com.york.service.TypeInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class StatisticsController {

    @Resource
    private BookInfoService bookInfoService;

    @Resource
    private TypeInfoService typeInfoService;

    /**
     * 统计首页
     *
     * @param model 模型
     * @return Jsp Page
     */
    @GetMapping("statisticIndex")
    public String statistics(Model model){
        //根据图书类型查询图书数量
        List<BookInfo> list = bookInfoService.getBookCountByType();
        model.addAttribute("list",list);

        return "count/statisticIndex";
    }
}
