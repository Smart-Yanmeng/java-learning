package com.york.principles.demo03.after;

public class XiJieHardDisk implements HardDisk {

    // 存储数据
    public void save(String data) {
        System.out.println("使用希捷硬盘存储数据为 -> " + data);
    }

    // 获取数据
    public String get() {
        System.out.println("使用希捷硬盘获取数据");

        return "数据";
    }
}
