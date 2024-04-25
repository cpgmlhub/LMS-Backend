package com.example.library.config;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.library.model.Catalogue;

@FeignClient(name = "Catalogue", url = "${catalogue.service.url}")
public interface CatalogueFeignClient {

    @PostMapping("/catalogue/create-catalogue")
    Catalogue createCatalogue(@RequestBody Catalogue catalogue);

    @GetMapping("/catalogue/view-catalogues")
    List<Catalogue> getAllCatalogues();

    @DeleteMapping("/catalogue/delete-catalogue/{id}")
    ResponseEntity<String> deleteCatalogue(@PathVariable String id);

    @GetMapping("/catalogue/search-catalogue/{id}")
    ResponseEntity<Catalogue> searchCatalogueById(@PathVariable String id);
}
