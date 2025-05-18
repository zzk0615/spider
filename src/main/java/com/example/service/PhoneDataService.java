package com.example.service;

import com.example.entity.PhoneData;
import java.util.List;
import java.util.Map;

public interface PhoneDataService {
    List<PhoneData> searchPhones(Map<String, String> searchParams);
    List<PhoneData> getAllPhones();
    void savePhone(PhoneData phoneData);
    void updatePhone(PhoneData phoneData);
    void deletePhone(Long id);
} 