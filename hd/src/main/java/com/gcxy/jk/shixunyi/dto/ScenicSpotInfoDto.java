package com.gcxy.jk.shixunyi.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@ApiModel("景点详情DTO")
public class ScenicSpotInfoDto {

    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("景点名称")
    private String scenicName;

    @ApiModelProperty("景点详细地址")
    private String scenicAddress;

    @ApiModelProperty("景点描述")
    private String scenicDescribe;

    @ApiModelProperty("景点图片名称")
    private String scenicImage;

    @ApiModelProperty("地理经度")
    private BigDecimal longitude;

    @ApiModelProperty("地理纬度")
    private BigDecimal latitude;


}