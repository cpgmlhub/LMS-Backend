package com.example.library.controller;

import com.example.library.config.CirculationFeignClient;
import com.example.library.model.Circulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/circulation")
@CrossOrigin(origins = "http://localhost:4200")
public class CirculationController {

    private final CirculationFeignClient circulationFeignClient;

    @Autowired
    public CirculationController(CirculationFeignClient circulationFeignClient) {
        this.circulationFeignClient = circulationFeignClient;
    }

    @PostMapping("/create-circulation")
    public ResponseEntity<Circulation> createCirculation(@RequestBody Circulation circulation) {
        Circulation createdCirculation = circulationFeignClient.createCirculation(circulation);
        return new ResponseEntity<>(createdCirculation, HttpStatus.CREATED);
    }

    @GetMapping("/view-circulations")
    public ResponseEntity<List<Circulation>> viewCirculations() {
        List<Circulation> circulations = circulationFeignClient.getAllCirculations();
        return ResponseEntity.ok(circulations);
    }

    @DeleteMapping("/delete-circulation/{id}")
    public ResponseEntity<String> deleteCirculation(@PathVariable String id) {
        return circulationFeignClient.deleteCirculation(id);
    }

    @GetMapping("/search-circulation/{id}")
    public ResponseEntity<Circulation> searchCirculationById(@PathVariable String id) {
        return circulationFeignClient.getCirculationById(id);
    }
}
