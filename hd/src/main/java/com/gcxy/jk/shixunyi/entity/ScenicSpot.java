package com.gcxy.jk.shixunyi.entity;

import java.math.BigDecimal;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "t_scenic_spot")
public class ScenicSpot {
    /**
     * 主键(雪花算法)
     */
    @Id
    private Long id;

    /**
     * 景点名称
     */
    @Column(name = "scenic_name")
    private String scenicName;

    /**
     * 景点详细地址
     */
    @Column(name = "scenic_address")
    private String scenicAddress;

    /**
     * 景点描述
     */
    @Column(name = "scenic_describe")
    private String scenicDescribe;

    /**
     * 景点图片名称
     */
    @Column(name = "scenic_image")
    private String scenicImage;

    /**
     * 地理经度
     */
    private BigDecimal longitude;

    /**
     * 地理纬度
     */
    private BigDecimal latitude;
}