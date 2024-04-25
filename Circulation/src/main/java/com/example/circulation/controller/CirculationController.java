package com.example.circulation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.circulation.model.Circulation;
import com.example.circulation.service.CirculationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/circulation")
public class CirculationController {

    private final CirculationService circulationService;

    @Autowired
    public CirculationController(CirculationService circulationService) {
        this.circulationService = circulationService;
    }

    @PostMapping("/create-circulation")
    public ResponseEntity<Circulation> createCirculation(@RequestBody Circulation circulation) {
        Circulation createdCirculation = circulationService.createCirculation(
            circulation.getMemberId(),
            circulation.getIssueDate(),
            circulation.getDueDate(),
            circulation.getItem()
        );
        return new ResponseEntity<>(createdCirculation, HttpStatus.CREATED);
    }

    @GetMapping("/view-circulations")
    public List<Circulation> getAllCirculations() {
        return circulationService.getAllCirculations();
    }
    
    @Transactional
    @DeleteMapping("/delete-circulation/{id}")
    public ResponseEntity<String> deleteCirculation(@PathVariable String id) {
        circulationService.deleteCirculationById(id);
        return ResponseEntity.ok("Circulation deleted successfully");
    }

    @GetMapping("/search-circulation/{id}")
    public ResponseEntity<Circulation> searchCirculationById(@PathVariable String id) {
        Optional<Circulation> circulation = circulationService.getCirculationById(id);
        return circulation.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
