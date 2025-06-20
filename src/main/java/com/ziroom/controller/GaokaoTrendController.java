package com.ziroom.controller;

import com.ziroom.common.ApiResponse;
import com.ziroom.entity.GaokaoTrend;
import com.ziroom.service.GaokaoTrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/gaokao-trend")
public class GaokaoTrendController {
    @Autowired
    private GaokaoTrendService service;

    @GetMapping
    public ResponseEntity<ApiResponse<List<GaokaoTrend>>> getAll() {
        return ResponseEntity.ok(ApiResponse.success(service.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GaokaoTrend>> getById(@PathVariable Long id) {
        Optional<GaokaoTrend> trend = service.getById(id);
        return trend.map(value -> ResponseEntity.ok(ApiResponse.success(value)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.error("未找到记录", 404)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<GaokaoTrend>> create(@RequestBody GaokaoTrend trend) {
        return ResponseEntity.ok(ApiResponse.success(service.save(trend)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<GaokaoTrend>> update(@PathVariable Long id, @RequestBody GaokaoTrend trend) {
        if (!service.getById(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.error("未找到记录", 404));
        }
        trend.setId(id);
        return ResponseEntity.ok(ApiResponse.success(service.save(trend)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        if (!service.getById(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.error("未找到记录", 404));
        }
        service.deleteById(id);
        return ResponseEntity.ok(ApiResponse.success(null));
    }
} 