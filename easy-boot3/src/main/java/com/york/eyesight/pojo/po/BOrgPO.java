package com.york.eyesight.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("org")
public class BOrgPO {

    @TableId(value = "org_id", type = IdType.AUTO)
    private Long orgId;

    private String orgName;

    private Integer orgType;
}
