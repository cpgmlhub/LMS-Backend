package com.example.catalogue.service;


import java.util.List;
import java.util.Optional;

import com.example.catalogue.model.Catalogue;

public interface CatalogueService {
	Catalogue createCatalogue(String name, String description, String author, String category);

	Long getNextCatalogueCountFromDatabase();
	
	List<Catalogue> getAllCatalogues();
 
	void deleteCatalogueById(String id);
	
	Optional<Catalogue> getCatalogueById(String id);
}

