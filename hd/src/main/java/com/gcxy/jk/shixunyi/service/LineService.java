package com.gcxy.jk.shixunyi.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.gcxy.jk.shixunyi.base.BaseService;
import com.gcxy.jk.shixunyi.dao.LineScenicMapper;
import com.gcxy.jk.shixunyi.dao.ScenicSpotMapper;
import com.gcxy.jk.shixunyi.dto.LineDto;
import com.gcxy.jk.shixunyi.entity.Line;
import com.gcxy.jk.shixunyi.entity.LineScenic;
import com.gcxy.jk.shixunyi.entity.ScenicSpot;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * 线路 Service
 * @author hujinghua
 * @date 2022/9/1 13:00
 */
@Service
@Slf4j
public class LineService extends BaseService<Line> {

    @Autowired
    private LineScenicMapper lineScenicMapper;

    @Autowired
    private ScenicSpotMapper scenicSpotMapper;

    public Map<String, List<LineDto>> fetchLineByCategory() {
        List<Line> lineList = this.mapper.selectAll();
        LinkedHashMap<String, List<Line>> map = lineList.stream().sorted(Comparator.comparing(Line::getSort)).collect(Collectors.groupingBy(Line::getLineCategory, LinkedHashMap::new, Collectors.toList()));
        Map<String, List<LineDto>> resutl = Maps.newLinkedHashMap();
        map.entrySet().stream().forEach(e -> {
            String key = e.getKey();
            List<Line> value = e.getValue();
            List<LineDto> valueDto = BeanUtil.copyToList(value, LineDto.class);
            resutl.put(key, valueDto);
        });

        return resutl;
    }

    public List<Map<String, Object>> fetchLineDetaile(String id) {
        LineScenic lineScenic = new LineScenic();
        lineScenic.setLineId(Long.parseLong(id));
        List<LineScenic> lineScenicList = lineScenicMapper.select(lineScenic);
        if(CollectionUtil.isEmpty(lineScenicList)) {
            return Lists.newArrayList();
        }
        Map<Long, LineScenic> scenicMap = lineScenicList.stream().collect(Collectors.toMap(LineScenic::getScenicId, Function.identity()));

        List<Long> ids = lineScenicList.stream().map(LineScenic::getScenicId).collect(Collectors.toList());
        List<ScenicSpot> scenicSpotList = scenicSpotMapper.selectByIds(StringUtils.join(ids, ","));
        List<Map<String, Object>> result = scenicSpotList.stream().map(e -> {
            Map<String, Object> beanToMap = BeanUtil.beanToMap(e);
            beanToMap.put("goTime", scenicMap.get(e.getId()).getGoTime());
            beanToMap.put("sort", scenicMap.get(e.getId()).getSort());
            return beanToMap;
        }).collect(Collectors.toList());
        return result;
    }
}
