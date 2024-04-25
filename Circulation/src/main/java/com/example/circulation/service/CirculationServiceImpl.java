package com.example.circulation.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.circulation.model.Circulation;
import com.example.circulation.repository.CirculationRepository;

@Service
public class CirculationServiceImpl implements CirculationService {

    private final CirculationRepository circulationRepository;

    @Autowired
    public CirculationServiceImpl(CirculationRepository circulationRepository) {
        this.circulationRepository = circulationRepository;
    }
    
    @Override
    public Circulation createCirculation(String memberId, Date issueDate, Date dueDate, String item) {
        long circularCount = circulationRepository.count();
        Circulation circulation = new Circulation();
        circulation.setId(generateId(circularCount));
        circulation.setMemberId(memberId);
        circulation.setIssueDate(issueDate);
        circulation.setDueDate(dueDate);
        circulation.setItem(item);
        return circulationRepository.save(circulation);
    }

    private String generateId(long catalogueCount) {
       // String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char firstChar = 'Z'; // Always use 'C' as the first character
        
        // Format the running numbers to have leading zeros (e.g., "0001")
        String runningNumbers = String.format("%04d", catalogueCount);
        
        // Concatenate the first character and running numbers
        return firstChar + runningNumbers;
    }

    
    @Override
    public Long getNextCirculationCountFromDatabase() {
        // This method queries the database to get the current catalogue count
        // It uses the count() method provided by Spring Data JPA repository
        long circularCount = circulationRepository.count();
        // Increment the count by 1 for the next ID
        return circularCount + 1;
    }

	
	 @Override
	    public List<Circulation> getAllCirculations() {
	        return circulationRepository.findAll();
	    }

	 @Override
	    public void deleteCirculationById(String id) {
	        circulationRepository.deleteById(id);
	    }

	 @Override
	    public Optional<Circulation> getCirculationById(String id) {
	        return circulationRepository.findById(id);
	    }

   
}
