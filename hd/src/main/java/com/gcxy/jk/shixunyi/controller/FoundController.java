package com.gcxy.jk.shixunyi.controller;

import com.gcxy.jk.shixunyi.dto.ScenicSpotInfoDto;
import com.gcxy.jk.shixunyi.service.ScenicSpotService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hujinghua
 * @date 2022/9/20 8:51
 */
@RequestMapping("/index")
@RestController
@Api(tags = "首页接口")
public class FoundController {

    @Autowired
    private ScenicSpotService scenicSpotService;

    @ApiOperation(notes = "推荐接口", value = "推荐接口")
    @GetMapping("/foundInfo")
    public ScenicSpotInfoDto foundInfo(String openid) {
        return scenicSpotService.foundInfo(openid);
    }

    @ApiOperation(notes = "收索接口", value = "收索接口")
    @GetMapping("/search")
    public ScenicSpotInfoDto search(String scenicName) {
        return scenicSpotService.search(scenicName);
    }
}
