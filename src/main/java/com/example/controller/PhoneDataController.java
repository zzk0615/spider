package com.example.controller;

import com.example.entity.PhoneData;
import com.example.service.PhoneDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/phones")
@CrossOrigin(origins = "*")
public class PhoneDataController {

    @Autowired
    private PhoneDataService phoneDataService;

    @GetMapping("/search")
    public ResponseEntity<List<PhoneData>> searchPhones(@RequestParam Map<String, String> searchParams) {
        return ResponseEntity.ok(phoneDataService.searchPhones(searchParams));
    }

    @GetMapping
    public ResponseEntity<List<PhoneData>> getAllPhones() {
        return ResponseEntity.ok(phoneDataService.getAllPhones());
    }

    @PostMapping
    public ResponseEntity<Void> savePhone(@RequestBody PhoneData phoneData) {
        phoneDataService.savePhone(phoneData);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePhone(@PathVariable Long id, @RequestBody PhoneData phoneData) {
        phoneData.setId(id);
        phoneDataService.updatePhone(phoneData);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhone(@PathVariable Long id) {
        phoneDataService.deletePhone(id);
        return ResponseEntity.ok().build();
    }
} 