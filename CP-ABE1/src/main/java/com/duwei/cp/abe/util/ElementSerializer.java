package com.duwei.cp.abe.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import it.unisa.dia.gas.jpbc.Element;

import java.io.IOException;

public class ElementSerializer extends JsonSerializer<Element> {

    @Override
    public void serialize(Element element, JsonGenerator gen, SerializerProvider serializers) throws IOException {

        // 序列化 Element 对象
        gen.writeBinary(element.toBytes());
    }
}
