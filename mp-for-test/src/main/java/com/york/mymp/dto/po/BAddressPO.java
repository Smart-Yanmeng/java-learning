package com.york.mymp.dto.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("address")
public class BAddressPO {

    private Long id;

    private Long userId;

    private String province;

    private String city;

    private String town;

    private String mobile;

    private String street;

    private String contact;

    @TableField("is_default")
    private boolean isDefault;

    private String notes;

    @TableField("deleted")
    private boolean isDeleted;
}
