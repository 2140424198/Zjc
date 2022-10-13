package com.gcxy.jk.shixunyi.service;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.net.URLDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.charset.StandardCharsets;

/**
 * 图片service
 * @author hujinghua
 * @date 2022/9/1 13:37
 */
@Service
@Slf4j
public class PictureService {

    // 图片根路径
    private final String ROOT_PATH = this.getClass().getResource("/").getPath();
    private final String IMAGE_PARENT_PATH = URLDecoder.decodeForPath(ROOT_PATH+"static/images/", StandardCharsets.UTF_8);

    /**
     * 通过图片名称获取图片字节数组
     * @param name
     * @return
     */
    public byte[] findByName(String name) {
        File file = FileUtil.file(IMAGE_PARENT_PATH, URLDecoder.decode(name, StandardCharsets.UTF_8));
        return FileUtil.readBytes(file);
    }

}
