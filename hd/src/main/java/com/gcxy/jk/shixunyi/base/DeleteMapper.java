package com.gcxy.jk.shixunyi.base;

import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.base.delete.DeleteByPrimaryKeyMapper;
import tk.mybatis.mapper.common.condition.DeleteByConditionMapper;
import tk.mybatis.mapper.common.ids.DeleteByIdsMapper;

/**
 * 基础删除mapper
 * @author hujinghua
 * @date 2022/8/31 18:35
 */
public interface DeleteMapper<T> extends Marker,
    tk.mybatis.mapper.common.base.delete.DeleteMapper<T>,
    DeleteByPrimaryKeyMapper<T>,
    DeleteByConditionMapper<T>,
    DeleteByIdsMapper<T> {
}