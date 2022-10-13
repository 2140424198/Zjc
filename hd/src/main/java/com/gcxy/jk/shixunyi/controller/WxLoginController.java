package com.gcxy.jk.shixunyi.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.gcxy.jk.shixunyi.dto.WxUserDto;
import com.gcxy.jk.shixunyi.dto.WxUserResponseDto;
import com.gcxy.jk.shixunyi.service.UserService;
import com.gcxy.jk.shixunyi.utils.WeChatUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用于微信登录
 * @author hujinghua
 * @date 2022/9/14 9:54
 */
@Slf4j
@RestController
public class WxLoginController {

    @Value("${wxMini.appId}")
    private String appId;

    @Value("${wxMini.secret}")
    private String secret;

    private String loginUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";

    @Autowired
    private UserService userService;

    @ApiOperation(value = "微信登录接口", notes = "微信登录接口")
    @PostMapping("/wxLogin")
    public WxUserResponseDto wxLogin(@RequestBody WxUserDto userDto) {
        String url = loginUrl.replace("APPID", appId)
                .replace("SECRET", secret)
                .replace("JSCODE", userDto.getCode());

        // 去微信小程序官网获取openid
        String response = WeChatUtil.httpRequest(url, "GET", "");
        log.info(response);
        JSONObject parseObj = JSONUtil.parseObj(response);
        log.info(parseObj.toString());
        String openid = parseObj.getStr("openid");

        WxUserResponseDto responseDto = userService.bind(userDto.getNickName(), userDto.getAvatarUrl(), userDto.getGender(), openid);

        return responseDto;
    }
}
