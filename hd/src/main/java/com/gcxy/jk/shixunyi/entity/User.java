package com.gcxy.jk.shixunyi.entity;

import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "t_user")
public class User {
    /**
     * 主键(雪花算法)
     */
    @Id
    private Long id;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 微信openid
     */
    private String openid;

    /**
     * 性别
     */
    private Boolean gender;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    @Column(name = "create_user")
    private Long createUser;

    /**
     * 修改人
     */
    @Column(name = "update_user")
    private Long updateUser;

    /**
     * 头像url
     */
    @Column(name = "head_portrait")
    private String headPortrait;
}