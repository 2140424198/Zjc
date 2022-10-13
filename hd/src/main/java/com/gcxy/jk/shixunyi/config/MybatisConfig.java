package com.gcxy.jk.shixunyi.config;

import com.gcxy.jk.shixunyi.base.BaseMapper;
import com.gcxy.jk.shixunyi.interceptor.PrimaryKeyInterceptor;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.mapper.entity.Config;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

/**
 * mybatis 配置类
 * @author hujinghua
 * @date 2022/8/31 20:48
 */
@Configuration
@AutoConfigureAfter(MybatisAutoConfiguration.class)
public class MybatisConfig {

    private final String DAO_PATH = "com.gcxy.jk.shixunyi.dao";

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage(DAO_PATH);

        Properties properties = new Properties();
        properties.setProperty("mappers", BaseMapper.class.getName());
        properties.setProperty("notEmpty", "false");
        properties.setProperty("IDENTITY", "MYSQL");
        properties.setProperty("ORDER", "BEFORE");

        MapperHelper mapperHelper = new MapperHelper();
        Config config = new Config();
        // 其他配置
        // 主键自增回写方法执行顺序,默认AFTER,可选值为(BEFORE|AFTER)
        config.setOrder("BEFORE");
        mapperHelper.setConfig(config);

        mapperScannerConfigurer.setProperties(properties);
        mapperScannerConfigurer.setMapperHelper(mapperHelper);
        return mapperScannerConfigurer;
    }

    //创建雪花算法拦截器
    @Bean
    public PrimaryKeyInterceptor primaryKeyInterceptor() {
        PrimaryKeyInterceptor primaryKeyInterceptor = new PrimaryKeyInterceptor();
        Properties properties = new Properties();
        properties.setProperty("primaryKey", "id");
        primaryKeyInterceptor.setProperties(properties);
        return primaryKeyInterceptor;
    }


}
