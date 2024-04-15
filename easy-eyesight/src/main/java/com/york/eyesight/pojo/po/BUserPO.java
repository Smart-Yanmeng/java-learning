package com.york.eyesight.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class BUserPO {

    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    private Long orgId;

    private String username;

    private String photoUrl;

    private String createTime;
}
