package com.ziroom.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "gaokao_trend")
public class GaokaoTrend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String province;
    private String city;
    private String name;
    private String batchTimes;
    private String pic;
    private String category;
    @Column(length = 256)
    private String feature; // 用逗号分隔字符串存储
} 