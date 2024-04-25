package com.example.catalogue.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.catalogue.model.Catalogue;
import com.example.catalogue.repository.CatalogueRepository;

@Service
public class CatalogueServiceImpl implements CatalogueService {

    private final CatalogueRepository catalogueRepository;

    @Autowired
    public CatalogueServiceImpl(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    @Override
    public Catalogue createCatalogue(String name, String description, String author, String category) {
        long catalogueCount = catalogueRepository.count();
        Catalogue catalogue = new Catalogue();
        catalogue.setId(generateId(catalogueCount));
        catalogue.setName(name);
        catalogue.setDescription(description);
        catalogue.setAuthor(author);
        catalogue.setCategory(category);
        return catalogueRepository.save(catalogue);
    }

    private String generateId(long catalogueCount) {
       // String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char firstChar = 'C'; // Always use 'C' as the first character
        
        // Format the running numbers to have leading zeros (e.g., "0001")
        String runningNumbers = String.format("%04d", catalogueCount);
        
        // Concatenate the first character and running numbers
        return firstChar + runningNumbers;
    }

    
    @Override
    public Long getNextCatalogueCountFromDatabase() {
        // This method queries the database to get the current catalogue count
        // It uses the count() method provided by Spring Data JPA repository
        long catalogueCount = catalogueRepository.count();
        // Increment the count by 1 for the next ID
        return catalogueCount + 1;
    }

	@Override
	public List<Catalogue> getAllCatalogues() {
        return catalogueRepository.findAll();
	}
	
	@Override
	@Transactional
	public void deleteCatalogueById(String id) {
	    catalogueRepository.deleteById(id);
	}
	
	 @Override
	 public Optional<Catalogue> getCatalogueById(String id) {
	     return catalogueRepository.findById(id);
	 }

   
}
