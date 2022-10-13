package com.gcxy.jk.shixunyi.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 审计功能--创建时间
 * @author hujinghua
 * @date 2022/8/31 17:05
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CreateTime {

}
