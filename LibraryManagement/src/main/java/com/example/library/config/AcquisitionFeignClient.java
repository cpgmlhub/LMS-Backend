package com.example.library.config;

import com.example.library.model.Acquisition;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "Acquisition", url = "${acquisition.service.url}")
public interface AcquisitionFeignClient {

    @PostMapping("/acquisition/create-acquisition")
    Acquisition createAcquisition(@RequestBody Acquisition acquisition);

    @GetMapping("/acquisition/view-acquisitions")
    List<Acquisition> getAllAcquisitions();

    @DeleteMapping("/acquisition/delete-acquisition/{id}")
    ResponseEntity<String> deleteAcquisition(@PathVariable String id);

    @GetMapping("/acquisition/search-acquisition/{id}")
    ResponseEntity<Acquisition> getAcquisitionById(@PathVariable String id);
}
