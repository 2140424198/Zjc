package com.gcxy.jk.shixunyi.controller;

import com.gcxy.jk.shixunyi.dto.ScenicSpotInfoDto;
import com.gcxy.jk.shixunyi.service.ScenicSpotService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 景点controller
 * @author hujinghua
 * @date 2022/9/1 12:50
 */
@Api(tags = "景点Controller API")
@Slf4j
@RestController
@RequestMapping("/scenicSpot")
public class ScenicSpotController {

    @Autowired
    private ScenicSpotService scenicSpotService;



    @ApiOperation(value = "查询单个景点详情", notes = "查询单个景点详情")
    @GetMapping(value = "findById/{id}")
    public ScenicSpotInfoDto findById(@PathVariable("id") Long id) {
        return scenicSpotService.findById(id);
    }

    @ApiOperation(value = "查询所有景点详情", notes = "查询所有景点详情")
    @GetMapping(value = "findAll")
    public List<ScenicSpotInfoDto> findAll() {
        return scenicSpotService.findAll();
    }

}
