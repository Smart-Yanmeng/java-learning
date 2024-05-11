package com.york.pattern.command;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private int diningTable;

    private Map<String, Integer> foodDir = new HashMap<String, Integer>();

    public int getDiningTable() {
        return diningTable;
    }

    public Map<String, Integer> getFoodDir() {
        return foodDir;
    }

    public void setDiningTable(int diningTable) {
        this.diningTable = diningTable;
    }

    public void setFood(String name, int num) {
        foodDir.put(name, num);
    }
}
