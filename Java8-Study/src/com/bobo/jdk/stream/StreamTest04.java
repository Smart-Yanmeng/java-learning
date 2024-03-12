package com.bobo.jdk.stream;

import java.util.*;
import java.util.stream.Stream;

public class StreamTest04 {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        Stream<String> stream1 = map.keySet().stream(); // key
        Stream<Object> stream2 = map.values().stream(); // value
        Stream<Map.Entry<String, Object>> stream3 = map.entrySet().stream(); // entry
    }
}
