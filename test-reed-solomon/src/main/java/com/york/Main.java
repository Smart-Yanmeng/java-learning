package com.york;

import com.york.erasure.ReedSolomon;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 原始字符串
        String originalString = """
                {
                  "patient": {
                    "id": "P123456",
                    "name": "John Doe",
                    "dateOfBirth": "1980-05-15",
                    "gender": "male",
                    "contact": {
                      "phone": "+1-800-123-4567",
                      "email": "john.doe@example.com"
                    }
                  },
                  "medicalRecord": {
                    "recordId": "MR987654",
                    "date": "2024-08-21",
                    "doctor": {
                      "id": "D78910",
                      "name": "Dr. Jane Smith",
                      "specialty": "Cardiology"
                    },
                    "diagnosis": [
                      {
                        "code": "I10",
                        "description": "Essential hypertension"
                      },
                      {
                        "code": "E11.9",
                        "description": "Type 2 diabetes mellitus without complications"
                      }
                    ],
                    "treatment": [
                      {
                        "medication": "Lisinopril",
                        "dosage": "10 mg",
                        "frequency": "daily"
                      },
                      {
                        "medication": "Metformin",
                        "dosage": "500 mg",
                        "frequency": "twice daily"
                      }
                    ],
                    "notes": "Patient shows improvement in blood pressure control and blood sugar levels."
                  },
                  "vitalSigns": {
                    "temperature": {
                      "value": 98.6,
                      "unit": "F"
                    },
                    "bloodPressure": {
                      "systolic": 120,
                      "diastolic": 80,
                      "unit": "mmHg"
                    },
                    "heartRate": {
                      "value": 72,
                      "unit": "bpm"
                    },
                    "respiratoryRate": {
                      "value": 16,
                      "unit": "breaths/min"
                    }
                  },
                  "labResults": {
                    "cholesterol": {
                      "total": 190,
                      "unit": "mg/dL",
                      "referenceRange": "125-200 mg/dL"
                    },
                    "glucose": {
                      "value": 100,
                      "unit": "mg/dL",
                      "referenceRange": "70-100 mg/dL"
                    },
                    "hemoglobinA1c": {
                      "value": 6.2,
                      "unit": "%",
                      "referenceRange": "4.0-5.6%"
                    }
                  }
                }
                """;

        // 计算所需参数
        int[] parameters = calculateShardsParameters(originalString.getBytes(StandardCharsets.UTF_8).length);
        int dataShardCount = parameters[0];
        int shardSize = parameters[1];
        int parityShardCount = 3;

        System.out.println("Total data shards: " + dataShardCount);
        System.out.println("Total parity shards: " + parityShardCount);
        System.out.println("Shard size: " + shardSize);
        System.out.println("Total shards: " + (dataShardCount + parityShardCount));
        System.out.println("Shards needed for recovery: " + dataShardCount);

        // 创建 Reed-Solomon 编码器
        ReedSolomon codec = ReedSolomon.create(dataShardCount, parityShardCount);

        // 拆分字符串
        byte[][] shards = splitStringIntoDataShards(originalString, dataShardCount, parityShardCount, shardSize);

        // 编码生成纠删码
        codec.encodeParity(shards, 0, shardSize);

        // 打印编码后的 shards
        System.out.println("Encoded Shards: ");
        for (byte[] shard : shards) {
            System.out.println(Arrays.toString(shard));
        }

        // 模拟丢失数据
        shards[0] = new byte[shardSize]; // 丢失一个数据 shard
        shards[1] = new byte[shardSize]; // 丢失一个数据 shard
        shards[2] = new byte[shardSize]; // 丢失一个数据 shard
        boolean[] shardPresent = new boolean[shards.length];
        Arrays.fill(shardPresent, true);
        shardPresent[0] = false; // 标记丢失的 shard
        shardPresent[1] = false; // 标记丢失的 shard
        shardPresent[2] = false; // 标记丢失的 shard

        // 尝试恢复丢失的数据
        try {
            codec.decodeMissing(shards, shardPresent, 0, shardSize);
        } catch (IllegalArgumentException e) {
            System.err.println("Error during decoding: " + e.getMessage());
            return; // 退出程序
        }

        // 合并恢复后的字符串
        String reconstructedString = mergeShardsIntoString(shards, dataShardCount);
        System.out.println("Reconstructed String: ");
        System.out.println(reconstructedString);
    }

    // 自动计算 shards 参数
    public static int[] calculateShardsParameters(int dataSize) {
        // 设定最小和最大分片大小（字节）
        int minShardSize = 64; // 最小分片大小（64字节）
        int maxShardSize = 512; // 最大分片大小（512字节）

        // 固定数据分片数量为10，冗余分片数量为3
        int dataShardCount = 10;

        // 计算每个数据分片的大小
        int shardSize = (int) Math.ceil((double) dataSize / dataShardCount);

        // 检查是否在允许的分片大小范围内
        if (shardSize < minShardSize || shardSize > maxShardSize) {
            throw new IllegalArgumentException("Shard size is out of the allowable range.");
        }

        return new int[]{dataShardCount, shardSize};
    }

    public static byte[][] splitStringIntoDataShards(String str, int dataShardCount, int parityShardCount, int shardSize) {
        byte[] data = str.getBytes(StandardCharsets.UTF_8);
        int totalShards = dataShardCount + parityShardCount;
        byte[][] shards = new byte[totalShards][shardSize];

        // 填充数据 shards
        int dataLength = data.length;
        for (int i = 0; i < dataShardCount; i++) {
            int start = i * shardSize;
            int end = Math.min(start + shardSize, dataLength);
            int length = end - start;

            if (length > 0) {
                System.arraycopy(data, start, shards[i], 0, length);
            }
        }

        return shards;
    }

    public static String mergeShardsIntoString(byte[][] shards, int dataShardCount) {
        byte[] data = new byte[dataShardCount * shards[0].length];
        int index = 0;
        for (int i = 0; i < dataShardCount; i++) {
            System.arraycopy(shards[i], 0, data, index, shards[i].length);
            index += shards[i].length;
        }
        return new String(data, StandardCharsets.UTF_8);
    }
}
