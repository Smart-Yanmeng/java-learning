package com.example.springbootswagger.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Clazz {

  //  @NotNull
  @NotBlank
  @ApiModelProperty(value = "班级名称", required = true)
  private String name;

  @ApiModelProperty("班级id")
  private String id;

  private String password;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
