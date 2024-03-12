package com.mashang.controller;

import com.mashang.vo.ResultView;
import com.mashang.vo.StudentQueryVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// 控制器, 用来处理前端发过来的 http 请求
@Controller // 注册成一个控制器
@RequestMapping("/student") // 一级路径
public class StudentController {

    @RequestMapping(value = "/queryStudent", method = RequestMethod.GET) // 二级路径
    public String queryStudent() {
        System.out.println("查询学生");

        return "index"; // 指定了视图名称
    }

    @RequestMapping("/addStudent")
    public void addStudent() {

    }

    // 传统写法
    @GetMapping("/getData1")
    public void getData1(String name, String age) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
    }

    // resultFull 风格的写法
    @PostMapping
    public void getData2(String name, String age) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
    }

    @GetMapping("/getData3")
    public void getData3(@RequestParam(value = "name", required = false) String name123, String age) {
        System.out.println("name = " + name123);
        System.out.println("age = " + age);
    }

    // 常用方式
    // Delete
    @GetMapping("getData4/{id}/{delId}")
    public void getData4(@PathVariable String id, @PathVariable String delId) {
        System.out.println("id = " + id);
        System.out.println("delId = " + delId);
    }

    // 表单提交
    @PostMapping("/getData5")
    public void getData5(StudentQueryVo vo) {
        System.out.println(vo.toString());
    }

    // JSON 数据提交
    @PostMapping("/getData6")
    public void getData6(@RequestBody StudentQueryVo vo) {
        System.out.println(vo.toString());
    }

    // 返回 JSON 格式的数据
    @PostMapping("/getData7")
    @ResponseBody // 返回的是一个 json 数据, 而不是视图
    public ResultView getData7(@RequestBody StudentQueryVo vo) {
        System.out.println(vo.toString());
        ResultView view = new ResultView();
        view.setMsg("操作成功");
        view.setCode(0);

        return view;
    }

}
