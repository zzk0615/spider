package com.example.service.impl;

import com.example.entity.PhoneData;
import com.example.service.PhoneDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PhoneDataServiceImpl implements PhoneDataService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<PhoneData> rowMapper = (rs, rowNum) -> {
        PhoneData phone = new PhoneData();
        phone.setId(rs.getLong("id"));
        phone.setManufacturer(rs.getString("manufacturer"));
        phone.setPhoneName(rs.getString("phone_name"));
        phone.setPrice(rs.getBigDecimal("price"));
        phone.setCpuModel(rs.getString("cpu_model"));
        phone.setSelfDevelopedChip(rs.getString("self_developed_chip"));
        phone.setScreenType(rs.getString("screen_type"));
        phone.setCameraConfig(rs.getString("camera_config"));
        phone.setBatteryCapacity(rs.getString("battery_capacity"));
        phone.setChargingSpeed(rs.getString("charging_speed"));
        phone.setSpeakerType(rs.getString("speaker_type"));
        phone.setWaterproofRating(rs.getString("waterproof_rating"));
        phone.setFingerprintType(rs.getString("fingerprint_type"));
        phone.setFrameMaterial(rs.getString("frame_material"));
        return phone;
    };

    @Override
    public List<PhoneData> searchPhones(Map<String, String> searchParams) {
        StringBuilder sql = new StringBuilder("SELECT * FROM phone_data WHERE 1=1");
        List<Object> params = new ArrayList<>();

        searchParams.forEach((key, value) -> {
            if (value != null && !value.trim().isEmpty()) {
                sql.append(" AND ").append(key).append(" LIKE ?");
                params.add("%" + value + "%");
            }
        });

        return jdbcTemplate.query(sql.toString(), params.toArray(), rowMapper);
    }

    @Override
    public List<PhoneData> getAllPhones() {
        return jdbcTemplate.query("SELECT * FROM phone_data", rowMapper);
    }

    @Override
    public void savePhone(PhoneData phoneData) {
        String sql = "INSERT INTO phone_data (manufacturer, phone_name, price, cpu_model, self_developed_chip, " +
                "screen_type, camera_config, battery_capacity, charging_speed, speaker_type, waterproof_rating, " +
                "fingerprint_type, frame_material) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        jdbcTemplate.update(sql,
                phoneData.getManufacturer(),
                phoneData.getPhoneName(),
                phoneData.getPrice(),
                phoneData.getCpuModel(),
                phoneData.getSelfDevelopedChip(),
                phoneData.getScreenType(),
                phoneData.getCameraConfig(),
                phoneData.getBatteryCapacity(),
                phoneData.getChargingSpeed(),
                phoneData.getSpeakerType(),
                phoneData.getWaterproofRating(),
                phoneData.getFingerprintType(),
                phoneData.getFrameMaterial());
    }

    @Override
    public void updatePhone(PhoneData phoneData) {
        String sql = "UPDATE phone_data SET manufacturer=?, phone_name=?, price=?, cpu_model=?, " +
                "self_developed_chip=?, screen_type=?, camera_config=?, battery_capacity=?, charging_speed=?, " +
                "speaker_type=?, waterproof_rating=?, fingerprint_type=?, frame_material=? WHERE id=?";
        
        jdbcTemplate.update(sql,
                phoneData.getManufacturer(),
                phoneData.getPhoneName(),
                phoneData.getPrice(),
                phoneData.getCpuModel(),
                phoneData.getSelfDevelopedChip(),
                phoneData.getScreenType(),
                phoneData.getCameraConfig(),
                phoneData.getBatteryCapacity(),
                phoneData.getChargingSpeed(),
                phoneData.getSpeakerType(),
                phoneData.getWaterproofRating(),
                phoneData.getFingerprintType(),
                phoneData.getFrameMaterial(),
                phoneData.getId());
    }

    @Override
    public void deletePhone(Long id) {
        jdbcTemplate.update("DELETE FROM phone_data WHERE id=?", id);
    }
} 