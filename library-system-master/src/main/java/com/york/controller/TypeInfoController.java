package com.york.controller;

import com.github.pagehelper.PageInfo;
import com.york.po.TypeInfo;
import com.york.service.TypeInfoService;
import com.york.utils.DataInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Controller
public class TypeInfoController {

    @Resource
    private TypeInfoService typeInfoService;

    /**
     * 类型管理首页
     *
     * @return Jsp Page
     */
    @GetMapping("/typeIndex")
    public String typeIndex() {
        return "type/typeIndex";
    }

    /**
     * 获取type数据信息，分页
     * 将 java 对象转为 json 格式的数据，表示该方法的返回结果直接写入 HTTP response body 中，一般在异步ajax获取数据时使用
     *
     * @return DataInfo
     */
    @RequestMapping("/typeAll")
    @ResponseBody
    public DataInfo typeAll(String name, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit) {
        PageInfo<TypeInfo> pageInfo = typeInfoService.queryTypeInfoAll(name, pageNum, limit);

        return DataInfo.ok("成功", pageInfo.getTotal(), pageInfo.getList());//总条数getTotal，数据封装成list,以便加载分页显示,由于加了ResponseBody,就会返回一个字符串
    }

    /**
     * 添加页面的跳转
     *
     * @return Jsp Page
     */
    @GetMapping("/typeAdd")
    public String typeAdd() {
        return "type/typeAdd";
    }

    /**
     * 类型添加提交
     *
     * @return Success Request
     */
    @PostMapping("/addTypeSubmit")
    @ResponseBody
    public DataInfo addTypeSubmit(TypeInfo info) {
        typeInfoService.addTypeSubmit(info);

        return DataInfo.ok();
    }

    /**
     * 类型根据id查询(修改)
     *
     * @return Jsp Page
     */
    @GetMapping("/queryTypeInfoById")
    public String queryTypeInfoById(Integer id, Model model) {
        TypeInfo info = typeInfoService.queryTypeInfoById(id);
        model.addAttribute("info", info);

        return "type/updateType";
    }

    /**
     * 修改提交功能
     *
     * @return DataInfo
     */
    @RequestMapping("/updateTypeSubmit")
    @ResponseBody
    public DataInfo updateTypeSubmit(@RequestBody TypeInfo info) {
        typeInfoService.updateTypeSubmit(info);

        return DataInfo.ok();
    }

    /**
     * 类型删除
     *
     * @return DataInfo
     */
    @RequestMapping("/deleteType")
    @ResponseBody
    public DataInfo deleteType(String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        typeInfoService.deleteTypeByIds(list);
        return DataInfo.ok();
    }
}
