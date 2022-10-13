package com.gcxy.jk.shixunyi.enums;

import lombok.AllArgsConstructor;

/**
 * 订单状态枚举
 * @author hujinghua
 * @date 2022/9/1 12:35
 */
@AllArgsConstructor
public enum OrderStatusEnum {
    UNPAID("已读"),PAID("未读"),FINISH("已完成");

    private String desc;

    public String getDesc() {
        return desc;
    }
}
