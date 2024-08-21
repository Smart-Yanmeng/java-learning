package com.york;

import com.york.erasure.ReedSolomon;
import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class MyTest {

    @Test
    public void testIdentity() {
        // 原始JSON字符串
        String json = "{\"name\":\"John\", \"age\":30, \"city\":\"New York\"}";

        // 转换为字节数组
        byte[] dataBytes = json.getBytes(StandardCharsets.UTF_8);

        // 设置数据块数(K)和校验块数(M)
        int dataShards = 4;
        int parityShards = 2;
        int totalShards = dataShards + parityShards;

        // 确定每个分片的大小
        int shardSize = (dataBytes.length + dataShards - 1) / dataShards;

        // 创建并分片数据块
        byte[][] shards = new byte[totalShards][shardSize];
        ByteBuffer buffer = ByteBuffer.wrap(dataBytes);

        for (int i = 0; i < dataShards; i++) {
            buffer.get(shards[i], 0, Math.min(shardSize, buffer.remaining()));
        }

        // 创建 Reed-Solomon 编码器
        ReedSolomon reedSolomon = ReedSolomon.create(dataShards, parityShards);

        // 生成校验块
        reedSolomon.encodeParity(shards, 0, shardSize);

        // 模拟数据恢复
        // 将其中两个数据块设置为空
        shards[0] = null;
        shards[1] = null;

        boolean[] shardPresent = new boolean[shards.length];
        shardPresent[0] = true;
        shardPresent[1] = false;

        // 使用纠删码恢复数据
        reedSolomon.decodeMissing(shards, shardPresent, 0, shardSize);

        // 组合恢复的数据
        ByteBuffer restoredBuffer = ByteBuffer.allocate(dataBytes.length);
        for (int i = 0; i < dataShards; i++) {
            restoredBuffer.put(shards[i], 0, shardSize);
        }

        // 将恢复的数据转换回字符串
        String restoredJson = new String(restoredBuffer.array(), StandardCharsets.UTF_8);
        System.out.println("Restored JSON: " + restoredJson);
    }
}
