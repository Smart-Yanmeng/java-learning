package com.york.pattern.combination;

import java.util.ArrayList;
import java.util.List;

public class Menu extends MenuComponent {

    private final List<MenuComponent> menuComponents = new ArrayList<MenuComponent>();

    public Menu(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int index) {
        return menuComponents.get(index);
    }

    @Override
    public void print() {
        System.out.println(name);

        for (MenuComponent menuComponent : menuComponents) {
            for (int i = 0; i < level; i++) {
                System.out.print("  ");
            }
            menuComponent.print();
        }
    }
}
