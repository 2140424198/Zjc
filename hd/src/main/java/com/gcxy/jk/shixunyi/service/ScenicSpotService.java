package com.gcxy.jk.shixunyi.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.RandomUtil;
import com.gcxy.jk.shixunyi.base.BaseService;
import com.gcxy.jk.shixunyi.dao.ScenicSpotMapper;
import com.gcxy.jk.shixunyi.dto.ScenicSpotInfoDto;
import com.gcxy.jk.shixunyi.entity.ScenicSpot;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


/**
 * 景点 Service
 * @author hujinghua
 * @date 2022/9/1 13:00
 */
@Service
@Slf4j
public class ScenicSpotService extends BaseService<ScenicSpot> {


    /**
     * 根据id查询景点信息
     * @param id
     * @return
     */
    public ScenicSpotInfoDto findById(Long id) {
        ScenicSpot scenicSpot = this.mapper.selectByPrimaryKey(id);
        return BeanUtil.toBean(scenicSpot, ScenicSpotInfoDto.class);
    }


    /**
     * 查询所有景点信息
     * @return
     */
    public List<ScenicSpotInfoDto> findAll() {
        List<ScenicSpot> scenicSpotList = this.mapper.selectAll();
        return BeanUtil.copyToList(scenicSpotList, ScenicSpotInfoDto.class);
    }

    /**
     * 获取首页推荐的内容
     * @param openid
     * @return
     */
    public ScenicSpotInfoDto foundInfo(String openid) {
        // openid为空的情况下，走默认推荐逻辑,随机推荐一个
        if(StringUtils.isBlank(openid)) {
            ScenicSpot scenicSpot = new ScenicSpot();
            // 1.获取数据库的总条数
            int count = this.mapper.selectCount(scenicSpot);
            if(count == 0) {
                return null;
            }

            // 2.在总条数的范围内随机的选择一个整数
            int randomInt = RandomUtil.randomInt(0, count);
            log.info("当前随机值是：{}", randomInt);

            // 3.从随机的整数开始，获取一条数据返回
            PageHelper.offsetPage(randomInt, 1);
            List<ScenicSpot> list = this.mapper.select(scenicSpot);
            return BeanUtil.toBean(list.get(0), ScenicSpotInfoDto.class);
        } else {
            // openid不为空的情况下，走专用的逻辑


        }

        return null;
    }

    public ScenicSpotInfoDto search(String scenicName) {
        if(StringUtils.isBlank(scenicName)) {
            return null;
        }
        Example build = Example.builder(ScenicSpot.class).build();
        build.createCriteria().andLike("scenicName", "%"+scenicName+"%");
        ScenicSpot scenicSpot = this.mapper.selectOneByExample(build);
        return BeanUtil.toBean(scenicSpot, ScenicSpotInfoDto.class);
    }
}
