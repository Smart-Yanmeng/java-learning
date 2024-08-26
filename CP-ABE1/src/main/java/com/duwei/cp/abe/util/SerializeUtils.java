package com.duwei.cp.abe.util;

import com.duwei.cp.abe.attribute.Attribute;
import com.duwei.cp.abe.parameter.PublicKey;
import com.duwei.cp.abe.parameter.SystemKey;
import com.duwei.cp.abe.structure.*;
import com.duwei.cp.abe.text.CipherText;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import it.unisa.dia.gas.jpbc.Element;

import java.lang.reflect.Type;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static com.duwei.cp.abe.test.Test.getAccessTree;

public class SerializeUtils {

    private Gson gson = new Gson();

    AccessTree accessTree = getAccessTree(SystemKey.build().getPublicKey());

    // 序列化 CipherText
    public String serializeCipherText(CipherText cipherText) {
        Map<String, Object> serializedData = new HashMap<>();

        // Serialize elements
        serializedData.put("c_wave", Base64.getEncoder().encodeToString(cipherText.getC_wave().toBytes()));
        serializedData.put("c", Base64.getEncoder().encodeToString(cipherText.getC().toBytes()));

        // Serialize c_y_map
        Map<String, String> cyMapStr = new HashMap<>();
        for (Map.Entry<Attribute, Element> entry : cipherText.getC_y_map().entrySet()) {
            cyMapStr.put(serializeAttribute(entry.getKey()), Base64.getEncoder().encodeToString(entry.getValue().toBytes()));
        }
        serializedData.put("cy_map", cyMapStr);

        // Serialize c_y_pie_map
        Map<String, String> cyPieMapStr = new HashMap<>();
        for (Map.Entry<Attribute, Element> entry : cipherText.getC_y_pie_map().entrySet()) {
            cyPieMapStr.put(serializeAttribute(entry.getKey()), Base64.getEncoder().encodeToString(entry.getValue().toBytes()));
        }
        serializedData.put("cy_pie_map", cyPieMapStr);

        // Serialize accessTree
        serializedData.put("access_tree", serializeAccessTree(cipherText.getAccessTree()));

        return gson.toJson(serializedData);
    }

    // 反序列化 CipherText
    public CipherText deserializeCipherText(String serializedCipherText, PublicKey pk) {
        AccessTreeNode root = accessTree.getRoot();

        Type type = new TypeToken<Map<String, Object>>() {
        }.getType();
        Map<String, Object> serializedData = gson.fromJson(serializedCipherText, type);

        CipherText cipherText = new CipherText();

        // Deserialize elements
        cipherText.setC_wave(pk.getPairingParameter().getG1().newElementFromBytes(Base64.getDecoder().decode((String) serializedData.get("c_wave"))).getImmutable());
        cipherText.setC(pk.getPairingParameter().getG0().newElementFromBytes(Base64.getDecoder().decode((String) serializedData.get("c"))).getImmutable());

        // Deserialize c_y_map
        Map<Attribute, Element> cyMap = new HashMap<>();
        Map<String, String> cyMapStr = (Map<String, String>) serializedData.get("cy_map");
        for (Map.Entry<String, String> entry : cyMapStr.entrySet()) {
            Attribute attribute = deserializeAttribute(entry.getKey(), pk);
            Element value = pk.getPairingParameter().getG0().newElementFromBytes(Base64.getDecoder().decode(entry.getValue())).getImmutable();
            cyMap.put(attribute, value);
        }
        cipherText.setC_y_map(cyMap);

        // Deserialize c_y_pie_map
        Map<Attribute, Element> cyPieMap = new HashMap<>();
        Map<String, String> cyPieMapStr = (Map<String, String>) serializedData.get("cy_pie_map");
        for (Map.Entry<String, String> entry : cyPieMapStr.entrySet()) {
            Attribute attribute = deserializeAttribute(entry.getKey(), pk);
            Element value = pk.getPairingParameter().getG0().newElementFromBytes(Base64.getDecoder().decode(entry.getValue())).getImmutable();
            cyPieMap.put(attribute, value);
        }
        cipherText.setC_y_pie_map(cyPieMap);

        // Deserialize accessTree
        AccessTree accessTree = deserializeAccessTree((String) serializedData.get("access_tree"), pk);

        cipherText.setAccessTree(accessTree);

        return cipherText;
    }

    // 序列化 Attribute
    public String serializeAttribute(Attribute attribute) {
        Map<String, String> serializedData = new HashMap<>();
        serializedData.put("attributeName", attribute.getAttributeName());

        String attributeValueStr = Base64.getEncoder().encodeToString(attribute.getAttributeValue().toBytes());
        serializedData.put("attributeValue", attributeValueStr);

        return gson.toJson(serializedData);
    }

    // 反序列化 Attribute
    public Attribute deserializeAttribute(String serializedAttribute, PublicKey publicKey) {
        Type type = new TypeToken<Map<String, String>>() {
        }.getType();
        Map<String, String> serializedData = gson.fromJson(serializedAttribute, type);

        String attributeName = serializedData.get("attributeName");
        byte[] attributeValueBytes = Base64.getDecoder().decode(serializedData.get("attributeValue"));
        Element attributeValue = publicKey.getPairingParameter().getG0().newElementFromBytes(attributeValueBytes).getImmutable();

        return new Attribute(attributeName, publicKey);
    }

    // 序列化 AccessTree
    private String serializeAccessTree(AccessTree accessTree) {
        return serializeAccessTreeNode(accessTree.getRoot());
    }

    private String serializeAccessTreeNode(AccessTreeNode node) {
        JsonObject nodeObject = new JsonObject();
        nodeObject.addProperty("type", node.getAccessTreeNodeType());
        nodeObject.addProperty("index", node.getIndex());
        nodeObject.addProperty("parentId", node.getParentId());

        if (node.getSecretNumber() != null) {
            nodeObject.addProperty("secretNumber", Base64.getEncoder().encodeToString(node.getSecretNumber().toBytes()));
        }

        if (node instanceof LeafAccessTreeNode) {
            LeafAccessTreeNode leafNode = (LeafAccessTreeNode) node;
            nodeObject.addProperty("attribute", serializeAttribute(leafNode.getAttribute()));
        } else if (node instanceof InnerAccessTreeNode) {
            InnerAccessTreeNode innerNode = (InnerAccessTreeNode) node;
            nodeObject.addProperty("threshold", innerNode.getThreshold());
        }

        JsonArray childrenArray = new JsonArray();
        for (AccessTreeNode child : node.getChildren()) {
            childrenArray.add(new Gson().fromJson(serializeAccessTreeNode(child), JsonElement.class));
        }
        nodeObject.add("children", childrenArray);

        return gson.toJson(nodeObject);
    }

    // 反序列化 AccessTree
    private AccessTree deserializeAccessTree(String json, PublicKey publicKey) {
        JsonObject rootNodeObject = gson.fromJson(json, JsonObject.class);
        AccessTreeNode root = deserializeAccessTreeNode(rootNodeObject, publicKey);
        return new AccessTree(root);
    }

    private AccessTreeNode deserializeAccessTreeNode(JsonObject serializedNode, PublicKey publicKey) {
        byte nodeType = serializedNode.get("type").getAsByte();
        AccessTreeNode node;

        if (nodeType == AccessTreeNodeType.INNER_NODE) {
            int threshold = serializedNode.get("threshold").getAsInt();
            node = new InnerAccessTreeNode(threshold, serializedNode.get("index").getAsInt());
        } else if (nodeType == AccessTreeNodeType.LEAF_NODE) {
            String attributeName = serializedNode.get("attribute").getAsString();
            node = new LeafAccessTreeNode(attributeName, publicKey, serializedNode.get("index").getAsInt());
        } else {
            throw new IllegalArgumentException("Unknown node type");
        }

        node.setParentId(serializedNode.get("parentId").getAsInt());

        if (serializedNode.has("secretNumber")) {
            byte[] secretNumberBytes = Base64.getDecoder().decode(serializedNode.get("secretNumber").getAsString());
            node.setSecretNumber(publicKey.getPairingParameter().getZr().newElementFromBytes(secretNumberBytes).getImmutable());
        }

        JsonArray childrenArray = serializedNode.getAsJsonArray("children");
        for (JsonElement childElement : childrenArray) {
            JsonObject childObject = childElement.getAsJsonObject();
            AccessTreeNode childNode = deserializeAccessTreeNode(childObject, publicKey);
            childNode.setParent(node);
            node.getChildren().add(childNode);
        }

        return node;
    }
}
