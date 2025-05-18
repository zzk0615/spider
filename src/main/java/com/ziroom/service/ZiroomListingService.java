package com.ziroom.service;

import com.ziroom.entity.ZiroomListing;
import com.ziroom.repository.ZiroomListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ZiroomListingService {
    
    @Autowired
    private ZiroomListingRepository repository;
    
    public List<ZiroomListing> getAllListings() {
        return repository.findAll();
    }
    
    public Set<String> getAllCities() {
        return repository.findAll().stream()
            .map(ZiroomListing::getCity)
            .collect(Collectors.toSet());
    }
    
    public Set<String> getDistrictsByCity(String city) {
        return repository.findByCity(city).stream()
            .map(ZiroomListing::getDistrict)
            .collect(Collectors.toSet());
    }
    
    public Set<String> getAllRoomTypes() {
        return repository.findAll().stream()
            .map(ZiroomListing::getRoomType)
            .collect(Collectors.toSet());
    }
    
    public List<ZiroomListing> getListingsByCity(String city) {
        return repository.findByCity(city);
    }
    
    public List<ZiroomListing> getListingsByCityAndDistrict(String city, String district) {
        return repository.findByCityAndDistrict(city, district);
    }
    
    public List<ZiroomListing> getListingsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return repository.findByPriceRange(minPrice, maxPrice);
    }
    
    public List<ZiroomListing> getListingsByRoomType(String roomType) {
        return repository.findByRoomType(roomType);
    }
    
    public List<ZiroomListing> getListingsByAreaRange(BigDecimal minArea, BigDecimal maxArea) {
        return repository.findByAreaRange(minArea, maxArea);
    }
    
    public Map<String, Long> getRoomTypeDistribution() {
        return repository.findAll().stream()
            .collect(Collectors.groupingBy(
                ZiroomListing::getRoomType,
                Collectors.counting()
            ));
    }
    
    public Map<String, Double> getAveragePriceByDistrict(String city) {
        return repository.findByCity(city).stream()
            .collect(Collectors.groupingBy(
                ZiroomListing::getDistrict,
                Collectors.averagingDouble(z -> z.getPriceMonth().doubleValue())
            ));
    }
} 