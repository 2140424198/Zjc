package com.gcxy.jk.shixunyi.interceptor;

import cn.hutool.core.bean.BeanUtil;
import com.gcxy.jk.shixunyi.utils.SnowflakeUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 键雪花算法
 * @author hujinghua
 * @date 2022/8/31 17:23
 */
@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class,Object.class})})
@Slf4j
public class PrimaryKeyInterceptor implements Interceptor {

    //主键生成策略
    private SnowflakeUtil snowflakeIdWorker;

    //主键标识
    private String primaryKey ;

    public PrimaryKeyInterceptor() {
        this.snowflakeIdWorker = new SnowflakeUtil(0, 0);
    }


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        if (args == null || args.length != 2) {
            return invocation.proceed();
        } else {
            MappedStatement ms = (MappedStatement) args[0];
            // 操作类型
            SqlCommandType sqlCommandType = ms.getSqlCommandType();
            // 只处理insert操作
            if (null != sqlCommandType && sqlCommandType == SqlCommandType.INSERT) {
                if (args[1] instanceof Map) {
                    // 批量插入
                    List list = (List) ((Map) args[1]).get("list");
                    for (Object obj : list) {
                        setProperty(obj, primaryKey, snowflakeIdWorker.nextId());
                    }
                } else {
                    setProperty(args[1], primaryKey, snowflakeIdWorker.nextId());
                }
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {

        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {
        //指定主键
        primaryKey = properties.getProperty("primaryKey");
        if (StringUtils.isEmpty(primaryKey)){
            primaryKey="id";
        }
    }

    /**
     * 设置对象属性值
     *
     * @param obj      对象
     * @param property 属性名称
     * @param value    属性值
     */
    private void setProperty(Object obj, String property, Object value)
            throws NoSuchFieldException,
            IllegalAccessException {

        Field field = obj.getClass().getDeclaredField(property);
        if (null != field) {
            field.setAccessible(true);
            Object val = field.get(obj);
            if (null == val) {
                BeanUtil.setProperty(obj, property, value);
            }
        }
    }
}

