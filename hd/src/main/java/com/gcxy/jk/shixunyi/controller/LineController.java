package com.gcxy.jk.shixunyi.controller;

import com.gcxy.jk.shixunyi.dto.LineDto;
import com.gcxy.jk.shixunyi.dto.ScenicSpotInfoDto;
import com.gcxy.jk.shixunyi.service.LineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author hujinghua
 * @date 2022/9/21 9:10
 */
@Api(tags = "线路API")
@RestController
@RequestMapping("/line")
public class LineController {

    @Autowired
    private LineService lineService;

    @ApiOperation(notes = "按分类获取线路", value = "按分类获取线路")
    @GetMapping("/fetchLineByCategory")
    public Map<String, List<LineDto>> fetchLineByCategory() {
        return lineService.fetchLineByCategory();
    }


    @ApiOperation(notes = "获取线路详情", value = "获取线路详情")
    @GetMapping("/fetchLineDetaile/{id}")
    public List<Map<String, Object>> fetchLineDetaile(@PathVariable("id") String id) {
        return lineService.fetchLineDetaile(id);
    }
}
