CREATE TABLE phone_data (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    manufacturer VARCHAR(50) COMMENT '手机厂商',
    phone_name VARCHAR(100) COMMENT '手机名称',
    price DECIMAL(10,2) COMMENT '手机价格',
    cpu_model VARCHAR(100) COMMENT 'CPU型号',
    self_developed_chip VARCHAR(50) COMMENT '自研芯片',
    screen_type VARCHAR(50) COMMENT '屏幕类型',
    camera_config VARCHAR(200) COMMENT '摄像头配置',
    battery_capacity VARCHAR(50) COMMENT '电池容量',
    charging_speed VARCHAR(50) COMMENT '充电速度',
    speaker_type VARCHAR(50) COMMENT '扬声器类型',
    waterproof_rating VARCHAR(20) COMMENT '防尘防水等级',
    fingerprint_type VARCHAR(50) COMMENT '指纹识别类型',
    frame_material VARCHAR(50) COMMENT '边框后盖材质',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='手机数据表';

-- 插入一些模拟数据
INSERT INTO phone_data (manufacturer, phone_name, price, cpu_model, self_developed_chip, screen_type, camera_config, battery_capacity, charging_speed, speaker_type, waterproof_rating, fingerprint_type, frame_material) VALUES
('小米', '小米14 Pro', 4999.00, '骁龙8 Gen 3', '澎湃P2', '2K AMOLED', '5000万主摄+5000万超广角+5000万长焦', '5000mAh', '120W', '立体声双扬声器', 'IP68', '超声波指纹', '陶瓷'),
('华为', 'Mate 60 Pro', 6999.00, '麒麟9000S', '麒麟NPU', 'OLED', '5000万主摄+4000万超广角+6400万长焦', '5000mAh', '88W', '立体声双扬声器', 'IP68', '屏下指纹', '素皮'),
('OPPO', 'Find X7 Ultra', 5999.00, '天玑9300', '马里亚纳X', '2K AMOLED', '5000万主摄+5000万超广角+5000万长焦', '5000mAh', '100W', '立体声双扬声器', 'IP68', '屏下指纹', '玻璃'),
('vivo', 'X100 Pro', 5499.00, '天玑9300', 'V2', '2K AMOLED', '5000万主摄+5000万超广角+5000万长焦', '5000mAh', '120W', '立体声双扬声器', 'IP68', '屏下指纹', '素皮'),
('苹果', 'iPhone 15 Pro', 7999.00, 'A17 Pro', '无', 'OLED', '4800万主摄+1200万超广角+1200万长焦', '3650mAh', '20W', '立体声双扬声器', 'IP68', 'Face ID', '钛金属'); 