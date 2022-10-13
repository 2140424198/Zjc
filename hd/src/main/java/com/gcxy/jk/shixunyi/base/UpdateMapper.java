package com.gcxy.jk.shixunyi.base;


import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.base.update.UpdateByPrimaryKeyMapper;
import tk.mybatis.mapper.common.base.update.UpdateByPrimaryKeySelectiveMapper;
import tk.mybatis.mapper.common.condition.UpdateByConditionMapper;
import tk.mybatis.mapper.common.condition.UpdateByConditionSelectiveMapper;
import tk.mybatis.mapper.common.example.UpdateByExampleSelectiveMapper;

/**
 * 基础更新mapper
 * @author hujinghua
 * @date 2022/8/31 18:33
 */
public interface UpdateMapper<T> extends Marker,
    UpdateByPrimaryKeyMapper<T>,
    UpdateByPrimaryKeySelectiveMapper<T>,
    UpdateByConditionMapper<T>,
    UpdateByConditionSelectiveMapper<T>,
    UpdateByExampleSelectiveMapper<T> {

}


