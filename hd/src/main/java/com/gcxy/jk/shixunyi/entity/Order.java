package com.gcxy.jk.shixunyi.entity;

import com.gcxy.jk.shixunyi.enums.OrderStatusEnum;
import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "t_order")
public class Order {
    /**
     * 主键(雪花算法)
     */
    @Id
    private Long id;

    /**
     * 订单金额
     */
    private Long amount;

    /**
     * 同行人数
     */
    @Column(name = "together_number")
    private Integer togetherNumber;

    /**
     * 预定时间
     */
    @Column(name = "reservation_time")
    private LocalDateTime reservationTime;

    /**
     * 订单状态(未支付，已支付，已完成)
     */
    private String status;

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
}