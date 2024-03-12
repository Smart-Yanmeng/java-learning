package com.mashang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/forwardSuccess")
    public String forwardSuccess() {
        System.out.println("转发");

        return "forward:/index.jsp";
    }

    @RequestMapping("/redirectPage")
    public String redirectPage() {
        System.out.println("重定向");

        return "redirect:/index.jsp";
    }

    @RequestMapping("/count")
    public String count() {
        int i = 10 / 0;

        return "success";
    }

    @RequestMapping("/interceptor")
    @ResponseBody
    public String interceptor() {
        System.out.println("interceptor");

        return "success";
    }

    @PostMapping("/uploadFile")
    @ResponseBody
    public String uploadFile(MultipartFile[] file) throws IOException {
        for (MultipartFile file1: file) {
            System.out.println("发送的文件: " + file1.getOriginalFilename());

            String srcFileName = UUID.randomUUID().toString() + "." + file1.getOriginalFilename().split("\\.")[1];

            File srcFile = new File("C:/Users/yorky/Desktop/uploadFile/" + srcFileName);
            if (!srcFile.getParentFile().exists()) {
                srcFile.mkdirs();
            }
            file1.transferTo(srcFile);
        }

        return "success";
    }
}
