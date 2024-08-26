package com.duwei.cp.abe.text;

import com.duwei.cp.abe.attribute.AttributeBytes;
import com.duwei.cp.abe.structure.AccessTree;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class CipherTextBytes {

    //g1
    private byte[] c_wave;

    //g0
    private byte[] c;

    //g0
    private Map<AttributeBytes, byte[]> c_y_map;

    //g0
    private Map<AttributeBytes, byte[]> c_y_pie_map;

    //访问树
    private AccessTree accessTree;

    public void putCy(AttributeBytes attribute, byte[] cy) {
        c_y_map.put(attribute, cy);
    }

    public void putCyPie(AttributeBytes attribute, byte[] cy_pie) {
        c_y_pie_map.put(attribute, cy_pie);
    }

    public byte[] getCy(AttributeBytes attribute) {
        return c_y_map.get(attribute);
    }

    public byte[] getCyPie(AttributeBytes attribute) {
        return c_y_pie_map.get(attribute);
    }

    public CipherTextBytes() {
        c_y_map = new HashMap<>();
        c_y_pie_map = new HashMap<>();
    }
}
