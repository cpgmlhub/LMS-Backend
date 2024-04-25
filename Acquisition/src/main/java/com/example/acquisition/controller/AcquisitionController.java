package com.example.acquisition.controller;

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

import com.example.acquisition.model.Acquisition;
import com.example.acquisition.service.AcquisitionService;

@RestController
@RequestMapping("/acquisition")
@CrossOrigin(origins = "http://localhost:4200")
public class AcquisitionController {

    private final AcquisitionService acquisitionService;

    @Autowired
    public AcquisitionController(AcquisitionService acquisitionService) {
        this.acquisitionService = acquisitionService;
    }

    @PostMapping("/create-acquisition")
    public ResponseEntity<Acquisition> createAcquisition(@RequestBody Acquisition acquisition) {
        Acquisition createdAcquisition = acquisitionService.createAcquisition(
            acquisition.getAcquisitionDate(),
            acquisition.getSource(),
            acquisition.getNote()
        );
        return new ResponseEntity<>(createdAcquisition, HttpStatus.CREATED);
    }

    @GetMapping("/view-acquisitions")
    public List<Acquisition> getAllAcquisitions() {
        return acquisitionService.getAllAcquisitions();
    }
    
    @Transactional
    @DeleteMapping("/delete-acquisition/{id}")
    public ResponseEntity<String> deleteAcquisition(@PathVariable String id) {
        acquisitionService.deleteAcquisitionById(id);
        return ResponseEntity.ok("Acquisition deleted successfully");
    }

    @GetMapping("/search-acquisition/{id}")
    public ResponseEntity<Acquisition> getAcquisitionById(@PathVariable String id) {
        Optional<Acquisition> acquisition = acquisitionService.getAcquisitionById(id);
        return acquisition.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
