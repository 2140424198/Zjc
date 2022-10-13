package com.gcxy.jk.shixunyi.controller;

import com.gcxy.jk.shixunyi.config.R;
import com.gcxy.jk.shixunyi.dao.OrderMapper;
import com.gcxy.jk.shixunyi.entity.Order;
import com.gcxy.jk.shixunyi.entity.OrderF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author lj
 * @data 2022/10/3 22:36
 */
@RestController
@RequestMapping("/order")
public class OrederController {
    @Autowired
    public OrderMapper orderMapper;

    @PostMapping("/save")
    public R save(OrderF orderF){
        Order order=new Order();
        LocalDateTime dateTime=LocalDateTime.parse(orderF.getPredicttime()+" 10:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        order.setAmount(orderF.getAmount().longValue());
        order.setCreateTime(LocalDateTime.now());
        order.setCreateUser(12L);
        order.setStatus("已支付");
        order.setUpdateTime(LocalDateTime.now());
        order.setUpdateUser(13L);
        order.setTogetherNumber(orderF.getNumerous());
        order.setReservationTime(dateTime);
        int insert = orderMapper.insert(order);
        if(insert!=0){
            return R.success("成功");
        }
        return R.success("失败");

    }
}
