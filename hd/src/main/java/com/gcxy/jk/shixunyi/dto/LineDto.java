package com.gcxy.jk.shixunyi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author hujinghua
 * @date 2022/9/21 9:11
 */
@Data
public class LineDto {

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("线路名称")
    private String lineName;

    @ApiModelProperty("线路价格")
    private BigDecimal lineAmount;

    @ApiModelProperty("线路分类排序")
    private Integer sort;

    @ApiModelProperty("线路备注")
    private String remark;

    @ApiModelProperty("线路图片")
    private String img;
}
