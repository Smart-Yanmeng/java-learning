package com.york.codeutil;

import lombok.Data;

@Data
public class VerifyCode {

    // 验证码
    private String code;

    // 验证码图片
    private byte[] imgBytes;

    // 过期时间
    private long expireTime;
}
