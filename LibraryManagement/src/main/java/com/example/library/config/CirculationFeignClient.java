package com.example.library.config;

import com.example.library.model.Circulation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "Circulation", url = "${circulation.service.url}")
public interface CirculationFeignClient {

    @PostMapping("/circulation/create-circulation")
    Circulation createCirculation(@RequestBody Circulation circulation);

    @GetMapping("/circulation/view-circulations")
    List<Circulation> getAllCirculations();

    @DeleteMapping("/circulation/delete-circulation/{id}")
    ResponseEntity<String> deleteCirculation(@PathVariable String id);

    @GetMapping("/circulation/search-circulation/{id}")
    ResponseEntity<Circulation> getCirculationById(@PathVariable String id);
}
