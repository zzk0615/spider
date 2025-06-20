package com.ziroom.service;

import com.ziroom.entity.GaokaoTrend;
import com.ziroom.repository.GaokaoTrendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GaokaoTrendService {
    @Autowired
    private GaokaoTrendRepository repository;

    public List<GaokaoTrend> getAll() {
        return repository.findAll();
    }

    public Optional<GaokaoTrend> getById(Long id) {
        return repository.findById(id);
    }

    public GaokaoTrend save(GaokaoTrend trend) {
        return repository.save(trend);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
} 