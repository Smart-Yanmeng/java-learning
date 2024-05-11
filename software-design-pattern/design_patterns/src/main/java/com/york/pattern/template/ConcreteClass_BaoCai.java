package com.york.pattern.template;

public class ConcreteClass_BaoCai extends AbstractClass {

    @Override
    public void pourVegetable() {
        System.out.println("倒包菜");
    }

    @Override
    public void pourSauce() {
        System.out.println("加辣椒");
    }
}
