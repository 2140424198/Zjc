package com.gcxy.jk.shixunyi.generator;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 逆向工程入口
 * @author hujinghua
 * @date 2022/8/31 19:10
 */
@Slf4j
public class MybatisGeneratorTest {
    @SneakyThrows
    @Test
    public void generator() {
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        InputStream inputStream = Resources.class.getClassLoader().getResourceAsStream("generator/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(inputStream);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        if(warnings.size() > 0) {
            log.error("********执行有误************");
            warnings.forEach(log::warn);
        } else {
            log.info("=============执行成功===========");
        }
    }
}
