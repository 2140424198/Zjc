package com.gcxy.jk.shixunyi.config;

import com.gcxy.jk.shixunyi.advice.ResponseBodyWrapAdvice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * mvc自定义配置
 * @author hujinghua
 * @date 2022/8/31 20:47
 */
@Configuration
@Slf4j
public class MyMvcConfig implements WebMvcConfigurer, InitializingBean {

    @Autowired
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;


    @Override
    public void afterPropertiesSet() throws Exception {
        List<HandlerMethodReturnValueHandler> handlerMethodReturnValueHandlers=requestMappingHandlerAdapter.getReturnValueHandlers();
        log.info("把自定义的HandlerMethodReturnValueHandler添加在RequestResponseBodyMethodProcessor的前面");
        List<HandlerMethodReturnValueHandler> returnValueHandlers = new ArrayList<>();
        handlerMethodReturnValueHandlers.forEach(e -> {
            if (e instanceof RequestResponseBodyMethodProcessor) {
                returnValueHandlers.add( new ResponseBodyWrapAdvice());
            }
            returnValueHandlers.add(e);
        });
        requestMappingHandlerAdapter.setReturnValueHandlers(returnValueHandlers);
    }
}

