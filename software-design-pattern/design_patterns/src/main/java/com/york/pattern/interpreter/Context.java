package com.york.pattern.interpreter;

import java.util.HashMap;
import java.util.Map;

public class Context {

    private final Map<Variable, Integer> map = new HashMap<Variable, Integer>();

    public void assign(Variable variable, Integer value) {
        map.put(variable, value);
    }

    public int getValue(Variable variable) {
        return map.get(variable);
    }
}
