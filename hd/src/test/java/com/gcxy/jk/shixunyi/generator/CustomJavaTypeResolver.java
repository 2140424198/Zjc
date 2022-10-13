package com.gcxy.jk.shixunyi.generator;

import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 逆向工程自定义类型
 * @author hujinghua
 * @date 2022/8/31 19:11
 */
public class CustomJavaTypeResolver extends JavaTypeResolverDefaultImpl {

    public CustomJavaTypeResolver() {
        super();
        // 在逆向工程生成model时，把Data类型替换成LocalDateTime类型
        this.typeMap.put(91, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("DATE", new FullyQualifiedJavaType(LocalDate.class.getName())));
        this.typeMap.put(92, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("TIME", new FullyQualifiedJavaType(LocalDateTime.class.getName())));
        this.typeMap.put(93, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("TIMESTAMP", new FullyQualifiedJavaType(LocalDateTime.class.getName())));
    }
}
