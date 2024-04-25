package com.example.circulation.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.circulation.model.Circulation;

public interface CirculationService {
	Circulation createCirculation(String memberId, Date issueDate, Date dueDate, String item);

	Long getNextCirculationCountFromDatabase();
	
	List<Circulation> getAllCirculations();
 
	void deleteCirculationById(String id);
	
	Optional<Circulation> getCirculationById(String id);
}

