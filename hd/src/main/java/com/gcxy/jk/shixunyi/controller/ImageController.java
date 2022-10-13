package com.gcxy.jk.shixunyi.controller;

import com.gcxy.jk.shixunyi.service.PictureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 * 图片Controller
 * @author hujinghua
 * @date 2022/9/1 14:40
 */
@Api(tags = "图片接口")
@Controller
@RequestMapping("img")
public class ImageController {

    @Autowired
    private PictureService pictureService;


    @SneakyThrows
    @ApiOperation("图片显示")
    @GetMapping("/show/{name}")
    public void showImg(@PathVariable("name") String name,  HttpServletResponse response) {
        ServletOutputStream os = response.getOutputStream();
        os.write(pictureService.findByName(name));
    }
}
