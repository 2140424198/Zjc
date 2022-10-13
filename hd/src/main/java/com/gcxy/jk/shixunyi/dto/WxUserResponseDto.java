package com.gcxy.jk.shixunyi.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * 微信登录响应DTO
 * @author hujinghua
 * @date 2022/9/1 12:33
 */
@ApiModel("微信登录响应DTO")
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class WxUserResponseDto {

    @ApiModelProperty("微信openid")
    private String openid;

    @ApiModelProperty("昵称")
    private String nickName;  //微信名

    @ApiModelProperty("头像URL")
    private String avatarUrl;  //头像

    @ApiModelProperty("性别")
    private Integer gender;  //性别 0 未知  1 男   2 女
}
