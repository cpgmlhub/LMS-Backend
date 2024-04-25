package com.example.library.controller;

import com.example.library.config.AcquisitionFeignClient;
import com.example.library.model.Acquisition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/acquisition")
@CrossOrigin(origins = "http://localhost:4200")
public class AcquisitionController {

    private final AcquisitionFeignClient acquisitionFeignClient;

    @Autowired
    public AcquisitionController(AcquisitionFeignClient acquisitionFeignClient) {
        this.acquisitionFeignClient = acquisitionFeignClient;
    }

    @PostMapping("/create-acquisition")
    public ResponseEntity<Acquisition> createAcquisition(@RequestBody Acquisition acquisition) {
        Acquisition createdAcquisition = acquisitionFeignClient.createAcquisition(acquisition);
        return new ResponseEntity<>(createdAcquisition, HttpStatus.CREATED);
    }

    @GetMapping("/view-acquisitions")
    public ResponseEntity<List<Acquisition>> viewAcquisitions() {
        List<Acquisition> acquisitions = acquisitionFeignClient.getAllAcquisitions();
        return ResponseEntity.ok(acquisitions);
    }

    @DeleteMapping("/delete-acquisition/{id}")
    public ResponseEntity<String> deleteAcquisition(@PathVariable String id) {
        return acquisitionFeignClient.deleteAcquisition(id);
    }

    @GetMapping("/search-acquisition/{id}")
    public ResponseEntity<Acquisition> searchAcquisitionById(@PathVariable String id) {
        return acquisitionFeignClient.getAcquisitionById(id);
    }
}
