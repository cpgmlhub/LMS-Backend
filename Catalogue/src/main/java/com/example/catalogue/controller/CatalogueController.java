package com.example.catalogue.controller;

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

import com.example.catalogue.model.Catalogue;
import com.example.catalogue.service.CatalogueService;

@RestController
@RequestMapping("/catalogue")
@CrossOrigin(origins = "http://localhost:4200")
public class CatalogueController {

    private final CatalogueService catalogueService;

    @Autowired
    public CatalogueController(CatalogueService catalogueService) {
        this.catalogueService = catalogueService;
    }

    @PostMapping("/create-catalogue")
    public ResponseEntity<Catalogue> createCatalogue(@RequestBody Catalogue catalogue) {
        Catalogue createdCatalogue = catalogueService.createCatalogue(
            catalogue.getName(),
            catalogue.getDescription(),
            catalogue.getAuthor(),
            catalogue.getCategory()
        );
        return new ResponseEntity<>(createdCatalogue, HttpStatus.CREATED);
    }
    
    @GetMapping("/view-catalogues")
    public List<Catalogue> getAllCatalogues() {
        return catalogueService.getAllCatalogues();
    }
    
    @Transactional
    @DeleteMapping("/delete-catalogue/{id}")
    public ResponseEntity<String> deleteCatalogue(@PathVariable String id) {
        catalogueService.deleteCatalogueById(id);
        return ResponseEntity.ok("Catalogue deleted successfully");
    }
    
    @GetMapping("/search-catalogue/{id}")
    public ResponseEntity<Catalogue> searchCatalogueById(@PathVariable String id) {
        Optional<Catalogue> catalogue = catalogueService.getCatalogueById(id);
        return catalogue.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

}
