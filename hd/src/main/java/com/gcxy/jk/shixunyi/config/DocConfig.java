package com.gcxy.jk.shixunyi.config;


import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * swagger 接口文档地址是(http://localhost:8080/shixunyi/doc.html)
 * @author hujinghua
 * @date 2022/8/31 18:36
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
public class DocConfig {

    private final String BASE_PACKAGE = "com.gcxy.jk.shixunyi.controller";

    @Bean
    public Docket defaultApi() {
        String groupName="3.X版本";
        Docket docket=new Docket(DocumentationType.OAS_30)
                .apiInfo(new ApiInfoBuilder()
                        .title("这是knife4j API ")
                        .description("# 这里记录服务端所有的接口的入参，出参等等信息")
                        .termsOfServiceUrl("")
                        .contact(new Contact("hjh","","1953959817@qq.com"))
                        .version("3.0")
                        .build())
                //分组名称
                .groupName(groupName)
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }



}

