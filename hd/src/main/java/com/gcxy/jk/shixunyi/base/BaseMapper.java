package com.gcxy.jk.shixunyi.base;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * 基础mapper
 * @author hujinghua
 * @date 2022/8/31 17:25
 */
public interface BaseMapper<T> extends
        InsertMapper<T>,
        DeleteMapper<T>,
        UpdateMapper<T>,
        SelectMapper<T>,
        ConditionMapper<T>,
        IdsMapper<T>,
    Mapper<T> {

}
