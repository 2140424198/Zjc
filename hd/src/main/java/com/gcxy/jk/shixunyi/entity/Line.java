package com.gcxy.jk.shixunyi.entity;

import java.math.BigDecimal;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "t_line")
public class Line {
    /**
     * 主键(雪花算法)
     */
    @Id
    private Long id;

    /**
     * 线路名称
     */
    @Column(name = "line_name")
    private String lineName;

    /**
     * 线路分类
     */
    @Column(name = "line_category")
    private String lineCategory;

    /**
     * 线路分类排序
     */
    private Integer sort;

    /**
     * 线路价格
     */
    @Column(name = "line_amount")
    private BigDecimal lineAmount;

    /**
     * 线路图片
     */
    private String img;

    /**
     * 线路备注
     */
    private String remark;
}