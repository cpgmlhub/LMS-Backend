package com.example.acquisition.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.acquisition.model.Acquisition;
import com.example.acquisition.repository.AcquisitionRepository;


@Service
public class AcquisitionServiceImpl implements AcquisitionService {

    private final AcquisitionRepository acquisitionRepository;

    @Autowired
    public AcquisitionServiceImpl(AcquisitionRepository acquisitionRepository) {
        this.acquisitionRepository = acquisitionRepository;
    }
    
    @Override
    public Acquisition createAcquisition(Date acquisitionDate, String source, String note) {
    	long acquisitionCount = acquisitionRepository.count();
        Acquisition acquisition = new Acquisition();
        acquisition.setId(generateId(acquisitionCount));
        acquisition.setAcquisitionDate(acquisitionDate);
        acquisition.setSource(source);
        acquisition.setNote(note);
        return acquisitionRepository.save(acquisition);
    }

    private String generateId(long acquisitionCount) {
       // String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char firstChar = 'A'; // Always use 'A' as the first character
        
        // Format the running numbers to have leading zeros (e.g., "0001")
        String runningNumbers = String.format("%04d", acquisitionCount);
        
        // Concatenate the first character and running numbers
        return firstChar + runningNumbers;
    }

    
    @Override
    public Long getNextAcquisitionCountFromDatabase() {
        // This method queries the database to get the current catalogue count
        // It uses the count() method provided by Spring Data JPA repository
        long acquisitionCount = acquisitionRepository.count();
        // Increment the count by 1 for the next ID
        return acquisitionCount + 1;
    }

    @Override
    public List<Acquisition> getAllAcquisitions() {
        return acquisitionRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteAcquisitionById(String id) {
        acquisitionRepository.deleteById(id);
    }

    @Override
    public Optional<Acquisition> getAcquisitionById(String id) {
        return acquisitionRepository.findById(id);
    }



   
}
