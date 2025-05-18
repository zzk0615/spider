package com.ziroom.controller;

import com.ziroom.common.ApiResponse;
import com.ziroom.entity.ZiroomListing;
import com.ziroom.service.ZiroomListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/listings")
public class ZiroomListingController {

    @Autowired
    private ZiroomListingService service;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ZiroomListing>>> getAllListings() {
        return ResponseEntity.ok(ApiResponse.success(service.getAllListings()));
    }

    @GetMapping("/cities")
    public ResponseEntity<ApiResponse<Set<String>>> getAllCities() {
        return ResponseEntity.ok(ApiResponse.success(service.getAllCities()));
    }

    @GetMapping("/cities/{city}/districts")
    public ResponseEntity<ApiResponse<Set<String>>> getDistrictsByCity(@PathVariable String city) {
        return ResponseEntity.ok(ApiResponse.success(service.getDistrictsByCity(city)));
    }

    @GetMapping("/room-types")
    public ResponseEntity<ApiResponse<Set<String>>> getAllRoomTypes() {
        return ResponseEntity.ok(ApiResponse.success(service.getAllRoomTypes()));
    }

    @GetMapping("/cities/{city}")
    public ResponseEntity<ApiResponse<List<ZiroomListing>>> getListingsByCity(@PathVariable String city) {
        return ResponseEntity.ok(ApiResponse.success(service.getListingsByCity(city)));
    }

    @GetMapping("/cities/{city}/districts/{district}")
    public ResponseEntity<ApiResponse<List<ZiroomListing>>> getListingsByDistrict(
            @PathVariable String city,
            @PathVariable String district) {
        return ResponseEntity.ok(ApiResponse.success(service.getListingsByCityAndDistrict(city, district)));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<ZiroomListing>>> searchListings(
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(required = false) BigDecimal minArea,
            @RequestParam(required = false) BigDecimal maxArea,
            @RequestParam(required = false) String roomType) {
        
        if (minPrice != null && maxPrice != null) {
            return ResponseEntity.ok(ApiResponse.success(service.getListingsByPriceRange(minPrice, maxPrice)));
        }
        if (minArea != null && maxArea != null) {
            return ResponseEntity.ok(ApiResponse.success(service.getListingsByAreaRange(minArea, maxArea)));
        }
        if (roomType != null) {
            return ResponseEntity.ok(ApiResponse.success(service.getListingsByRoomType(roomType)));
        }
        
        return ResponseEntity.badRequest().body(ApiResponse.error("请提供至少一个搜索条件", HttpStatus.BAD_REQUEST.value()));
    }

    @GetMapping("/statistics/room-types")
    public ResponseEntity<ApiResponse<Map<String, Long>>> getRoomTypeDistribution() {
        return ResponseEntity.ok(ApiResponse.success(service.getRoomTypeDistribution()));
    }

    @GetMapping("/statistics/cities/{city}/district-prices")
    public ResponseEntity<ApiResponse<Map<String, Double>>> getAveragePriceByDistrict(@PathVariable String city) {
        return ResponseEntity.ok(ApiResponse.success(service.getAveragePriceByDistrict(city)));
    }
} 