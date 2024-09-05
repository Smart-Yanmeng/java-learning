package com.duwei.cp.abe.util;

import com.duwei.cp.abe.parameter.PairingParameter;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import it.unisa.dia.gas.jpbc.Element;

import java.io.IOException;

public class ElementDeserializerFromG1 extends JsonDeserializer<Element> {

    @Override
    public Element deserialize(JsonParser p, DeserializationContext context) throws IOException {

        // 反序列化为 Element 对象
        return PairingParameter.getInstance().getG1().newElementFromBytes(p.getBinaryValue()).getImmutable();
    }
}
