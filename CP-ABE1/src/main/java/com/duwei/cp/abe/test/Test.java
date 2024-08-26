package com.duwei.cp.abe.test;

import com.duwei.cp.abe.attribute.Attribute;
import com.duwei.cp.abe.engine.CpAneEngine;
import com.duwei.cp.abe.parameter.*;
import com.duwei.cp.abe.structure.AccessTree;
import com.duwei.cp.abe.structure.AccessTreeBuildModel;
import com.duwei.cp.abe.structure.AccessTreeNode;
import com.duwei.cp.abe.text.CipherText;
import com.duwei.cp.abe.text.PlainText;
import com.duwei.cp.abe.util.SerializeUtils;
import it.unisa.dia.gas.jpbc.Pairing;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void test1() {

        CpAneEngine cpAneEngine = new CpAneEngine();

        // 1. 生成系统密钥  包含公钥-私钥
        SystemKey systemKey = SystemKey.build();

        // 2.1 设置用户 A 属性
        List<Attribute> userAAttributes = Arrays.asList(
//                new Attribute("学生", systemKey.getPublicKey()),
                new Attribute("二班", systemKey.getPublicKey())
        );

        // 2.2 设置用户 B 属性
        List<Attribute> userBAttributes = Arrays.asList(
                new Attribute("博士", systemKey.getPublicKey()),
                new Attribute("帅哥", systemKey.getPublicKey())
        );

        // 3. 生成用户 A 私钥
        UserPrivateKey userAPrivateKey = cpAneEngine.keyGen(systemKey.getMasterPrivateKey(), userAAttributes);
//        System.out.println("userAPrivateKey: " + userAPrivateKey);

        // 3. 生成用户 B 私钥
        UserPrivateKey userBPrivateKey = cpAneEngine.keyGen(systemKey.getMasterPrivateKey(), userBAttributes);
//        System.out.println("userBPrivateKey: " + userBPrivateKey);


        // 4.明文
        String plainTextStr = "Mp1XZU3JWA9gpMz6DrFFemn4te/6pSDVtn/a1zD1G5M=";
        PlainText plainText = new PlainText(plainTextStr, systemKey.getPublicKey());

        // 5.构建访问树
        AccessTree accessTree = getAccessTree(systemKey.getPublicKey());

        // 6.加密
        CipherText cipherText = cpAneEngine.encrypt(systemKey.getPublicKey(), plainText, accessTree);
        System.out.println(cipherText);
        System.out.println("====================================");

        // TEST //
        SerializeUtils serializeUtils = new SerializeUtils();
        String serializedCipherText = serializeUtils.serializeCipherText(cipherText);
        CipherText text = serializeUtils.deserializeCipherText(serializedCipherText, systemKey.getPublicKey());

        System.out.println(text);
        System.out.println("====================================");
        System.out.println(text.equals(cipherText));
        System.out.println(text.getC().equals(cipherText.getC()));
        System.out.println(text.getC_wave().equals(cipherText.getC_wave()));
        System.out.println(text.getC_y_map().equals(cipherText.getC_y_map()));
        System.out.println(text.getC_y_pie_map().equals(cipherText.getC_y_pie_map()));
        System.out.println(text.getAccessTree().equals(cipherText.getAccessTree()));

        // 7.用户 A 解密
        String decryptStrA = cpAneEngine.decryptToStr(systemKey.getPublicKey(), userAPrivateKey, cipherText);
        System.out.println("decryptStrA: " + decryptStrA);

        // 8.用户 B 解密
        String decryptStrB = cpAneEngine.decryptToStr(systemKey.getPublicKey(), userBPrivateKey, cipherText);
        System.out.println("decryptStrB: " + decryptStrB);
    }

    public static void main(String[] args) throws IOException {
        test1();
    }

    public static AccessTree getAccessTree(PublicKey publicKey) {

        AccessTreeBuildModel[] accessTreeBuildModels = new AccessTreeBuildModel[10];

        // 根节点 ID 必须为 1
        accessTreeBuildModels[0] = AccessTreeBuildModel.innerAccessTreeBuildModel(1, 2, 1, -1);
        accessTreeBuildModels[1] = AccessTreeBuildModel.leafAccessTreeBuildModel(2, 1, "学生", 1);
        accessTreeBuildModels[2] = AccessTreeBuildModel.leafAccessTreeBuildModel(3, 2, "老师", 1);
        accessTreeBuildModels[3] = AccessTreeBuildModel.leafAccessTreeBuildModel(4, 3, "博士", 1);
        accessTreeBuildModels[4] = AccessTreeBuildModel.innerAccessTreeBuildModel(5, 1, 4, 1);
        accessTreeBuildModels[5] = AccessTreeBuildModel.leafAccessTreeBuildModel(6, 1, "二班", 5);
        accessTreeBuildModels[6] = AccessTreeBuildModel.leafAccessTreeBuildModel(7, 2, "帅哥", 5);
        accessTreeBuildModels[7] = AccessTreeBuildModel.innerAccessTreeBuildModel(8, 1, 4, 1);
        accessTreeBuildModels[8] = AccessTreeBuildModel.leafAccessTreeBuildModel(9, 1, "ALL", 8);
        accessTreeBuildModels[9] = AccessTreeBuildModel.leafAccessTreeBuildModel(10, 2, "SUPER", 8);

        return AccessTree.build(publicKey, accessTreeBuildModels);
    }

    public static Pairing getPairing() {
        return PairingFactory.getPairing("params/curves/a.properties");
    }

    public static void pre(AccessTreeNode node) {
        System.out.println(node);
        for (AccessTreeNode child : node.getChildren()) {
            pre(child);
        }
    }
}
