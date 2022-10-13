package com.gcxy.jk.shixunyi.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 在前端json请求，传递参数为时间戳，然后转为LocalDateTime
 * @author hujinghua
 * @date 2022/8/31 17:10
 */
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@JsonDeserialize(using = LocalDateTimeDeserializer.class)
public @interface StampToLocalDateTime {


}

