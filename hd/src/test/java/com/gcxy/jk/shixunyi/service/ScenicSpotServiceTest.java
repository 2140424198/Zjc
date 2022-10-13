package com.gcxy.jk.shixunyi.service;

import cn.hutool.core.util.RandomUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hujinghua
 * @date 2022/9/20 9:41
 */
class ScenicSpotServiceTest {

    @Test
    public void testRandomInt() {
        for (int i = 0; i < 20; i++) {
            int randomInt = RandomUtil.randomInt(0, 10);
            System.out.println(randomInt);
        }
    }

}