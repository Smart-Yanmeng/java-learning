package com.york.mymp.dto.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("address")
public class BAddressPO {

    private Long id;

    private Long user_id;

    private String province;

    private String city;

    private String town;

    private String mobile;

    private String street;

    private String contact;

    private boolean is_default;

    private String notes;

    private boolean deleted;
}
