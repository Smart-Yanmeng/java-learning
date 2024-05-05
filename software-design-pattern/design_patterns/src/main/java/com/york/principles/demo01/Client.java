package com.york.principles.demo01;

public class Client {

    public static void main(String[] args) {

        // 1. 创建输入法对象
        DefaultInput input = new DefaultInput();

        // 2. 设置皮肤
        // DefaultSkin skin = new DefaultSkin();
        MySkin skin = new MySkin();
        input.setSkin(skin);

        // 3. 显示皮肤
        input.display();
    }
}
