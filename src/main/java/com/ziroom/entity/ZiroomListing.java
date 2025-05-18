package com.ziroom.entity;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "ziroom_listings")
public class ZiroomListing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "listing_id", unique = true, nullable = false)
    private String listingId;

    @Column(nullable = false)
    private String title;

    private String city;
    private String district;
    private String neighborhood;
    private String address;
    private BigDecimal longitude;
    private BigDecimal latitude;

    @Column(name = "price_month", nullable = false)
    private BigDecimal priceMonth;

    @Column(name = "room_type")
    private String roomType;

    @Column(name = "house_layout")
    private String houseLayout;

    @Column(name = "area_sqm")
    private BigDecimal areaSqm;

    @Column(name = "floor_info")
    private String floorInfo;

    private String orientation;

    @Column(name = "metro_info", columnDefinition = "TEXT")
    private String metroInfo;

    @Column(columnDefinition = "TEXT")
    private String tags;

    @Column(columnDefinition = "TEXT")
    private String amenities;

    @Column(name = "image_urls", columnDefinition = "TEXT")
    private String imageUrls;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "availability_date")
    @Temporal(TemporalType.DATE)
    private Date availabilityDate;

    @Column(name = "listing_url", unique = true, nullable = false)
    private String listingUrl;

    @Column(name = "scraped_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scrapedAt;
} 