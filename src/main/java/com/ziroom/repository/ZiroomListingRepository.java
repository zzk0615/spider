package com.ziroom.repository;

import com.ziroom.entity.ZiroomListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.math.BigDecimal;
import java.util.List;

public interface ZiroomListingRepository extends JpaRepository<ZiroomListing, Long> {
    
    List<ZiroomListing> findByCity(String city);
    
    List<ZiroomListing> findByCityAndDistrict(String city, String district);
    
    @Query("SELECT z FROM ZiroomListing z WHERE z.priceMonth BETWEEN ?1 AND ?2")
    List<ZiroomListing> findByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);
    
    @Query("SELECT z FROM ZiroomListing z WHERE z.roomType = ?1")
    List<ZiroomListing> findByRoomType(String roomType);
    
    @Query("SELECT z FROM ZiroomListing z WHERE z.areaSqm BETWEEN ?1 AND ?2")
    List<ZiroomListing> findByAreaRange(BigDecimal minArea, BigDecimal maxArea);
} 