package com.example.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PhoneData {
    private Long id;
    private String manufacturer;
    private String phoneName;
    private BigDecimal price;
    private String cpuModel;
    private String selfDevelopedChip;
    private String screenType;
    private String cameraConfig;
    private String batteryCapacity;
    private String chargingSpeed;
    private String speakerType;
    private String waterproofRating;
    private String fingerprintType;
    private String frameMaterial;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
} 