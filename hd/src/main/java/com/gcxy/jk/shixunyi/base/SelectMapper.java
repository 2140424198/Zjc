package com.gcxy.jk.shixunyi.base;

import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.base.select.*;
import tk.mybatis.mapper.common.condition.SelectByConditionMapper;
import tk.mybatis.mapper.common.condition.SelectCountByConditionMapper;
import tk.mybatis.mapper.common.example.SelectByExampleMapper;
import tk.mybatis.mapper.common.ids.SelectByIdsMapper;


/**
 * 基础查询mapper
 * @author hujinghua
 * @date 2022/8/31 18:33
 */
public interface SelectMapper<T> extends Marker,
    SelectOneMapper<T>,
    tk.mybatis.mapper.common.base.select.SelectMapper<T>,
    SelectAllMapper<T>,
    SelectCountMapper<T>,
    SelectByPrimaryKeyMapper<T>,
    ExistsWithPrimaryKeyMapper<T>,
    SelectByIdsMapper<T>,
    SelectByConditionMapper<T>,
    SelectCountByConditionMapper<T>,
    SelectByExampleMapper<T> {

}


