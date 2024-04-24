package src;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class TreeFactory {

    static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, Color color, String texture) {
        return treeTypes.computeIfAbsent(name, n -> new TreeType(n, color, texture));
    }
}
