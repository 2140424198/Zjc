package com.gcxy.jk.shixunyi.base;


import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.base.insert.InsertSelectiveMapper;

/**
 * 基础插入mapper
 * @author hujinghua
 * @date 2022/8/31 18:34
 */
public interface InsertMapper<T> extends Marker,
    tk.mybatis.mapper.common.base.insert.InsertMapper<T>,
    InsertSelectiveMapper<T>,
    MySqlMapper<T> {

}


