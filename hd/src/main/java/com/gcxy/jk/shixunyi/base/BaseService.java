package com.gcxy.jk.shixunyi.base;

import cn.hutool.core.collection.CollectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 基础service
 * @author hujinghua
 * @date 2022/8/31 18:35
 */
@Slf4j
public class BaseService<T> implements IBaseService<T> {

    @Autowired
    protected BaseMapper<T> mapper;

    /**
     * 通过id批量删除
     * @param idList
     */
    public void deleteByIdList(List<Long> idList) {
        if(CollectionUtil.isEmpty(idList)) {
            return;
        }
        String ids = StringUtils.join(idList, ",");
        mapper.deleteByIds(ids);
    }

}
