package com.gcxy.jk.shixunyi.service;

import cn.hutool.core.bean.BeanUtil;
import com.gcxy.jk.shixunyi.base.BaseService;
import com.gcxy.jk.shixunyi.dto.WxUserResponseDto;
import com.gcxy.jk.shixunyi.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author hujinghua
 * @date 2022/9/14 11:06
 */
@Service
public class UserService extends BaseService<User> {


    /**
     * 微信用户绑定
     * @param nickName
     * @param avatarUrl
     * @param gender
     * @param openid
     */
    public WxUserResponseDto bind(String nickName, String avatarUrl, Integer gender, String openid) {
        User user = new User();
        user.setOpenid(openid);

        // 通过openid去查询用户
        User us = this.mapper.selectOne(user);
        if(us == null) {
            // 没有就新增用户
            user.setNickName(nickName);
            user.setHeadPortrait(avatarUrl);
            user.setGender(Boolean.valueOf(gender.toString()));
            this.mapper.insert(user);
        } else {
            // 有就修改用户
            user.setNickName(nickName);
            user.setHeadPortrait(avatarUrl);
            this.mapper.updateByPrimaryKey(user);
        }

        WxUserResponseDto wxUserResponseDto = BeanUtil.toBean(user, WxUserResponseDto.class);
        wxUserResponseDto.setAvatarUrl(user.getHeadPortrait());
        return wxUserResponseDto;
    }
}
