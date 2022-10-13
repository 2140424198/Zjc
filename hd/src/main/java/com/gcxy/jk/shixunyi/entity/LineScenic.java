package com.gcxy.jk.shixunyi.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "t_line_scenic")
public class LineScenic {
    /**
     * 主键(雪花算法)
     */
    @Id
    private Long id;

    /**
     * 线路id
     */
    @Column(name = "line_id")
    private Long lineId;

    /**
     * 景点id
     */
    @Column(name = "scenic_id")
    private Long scenicId;

    /**
     * 景点次序
     */
    private Integer sort;

    /**
     * 前往时间
     */
    @Column(name = "go_time")
    private String goTime;
}