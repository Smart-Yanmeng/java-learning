package com.mashang.xiaomishopping.vo.product;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("查询商品列表")
public class ProductQueryListVo {

  @NotBlank
  @ApiModelProperty("当前页码")
  private Integer pageNum;

  @NotBlank
  @ApiModelProperty("每页数据条数")
  private Integer pageSize;

  @ApiModelProperty("分类 ID")
  private Integer categoryId;

  @ApiModelProperty("商品 ID")
  private Integer productId;

  @ApiModelProperty("商品名称")
  private String productName;

  public ProductQueryListVo(Integer pageNum, Integer pageSize, Integer categoryId, Integer productId, String productName) {
    this.pageNum = pageNum;
    this.pageSize = pageSize;
    this.categoryId = categoryId;
    this.productId = productId;
    this.productName = productName;
  }
}
