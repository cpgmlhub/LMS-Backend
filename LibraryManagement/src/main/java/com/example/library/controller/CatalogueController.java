package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.config.CatalogueFeignClient;
import com.example.library.model.Catalogue;

@RestController
@RequestMapping("/catalogue")
@CrossOrigin(origins = "http://localhost:4200")
public class CatalogueController {

	 @Autowired
	    private CatalogueFeignClient catalogueFeignClient;

	    @PostMapping("/create-catalogue")
	    public ResponseEntity<Catalogue> createCatalogue(@RequestBody Catalogue catalogue) {
	        Catalogue createdCatalogue = catalogueFeignClient.createCatalogue(catalogue);
	        return ResponseEntity.ok(createdCatalogue);
	    }

	    @GetMapping("/view-catalogues")
	    public ResponseEntity<List<Catalogue>> viewCatalogues() {
	        List<Catalogue> catalogues = catalogueFeignClient.getAllCatalogues();
	        return ResponseEntity.ok(catalogues);
	    }

	    @DeleteMapping("/delete-catalogue/{id}")
	    public ResponseEntity<String> deleteCatalogue(@PathVariable String id) {
	        return catalogueFeignClient.deleteCatalogue(id);
	    }

	    @GetMapping("/search-catalogue/{id}")
	    public ResponseEntity<Catalogue> searchCatalogueById(@PathVariable String id) {
	        return catalogueFeignClient.searchCatalogueById(id);
	    }
}
