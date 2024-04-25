package com.example.acquisition.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.acquisition.model.Acquisition;

public interface AcquisitionService {
    Acquisition createAcquisition(Date acquisitionDate, String source, String note);

    List<Acquisition> getAllAcquisitions();

    void deleteAcquisitionById(String id);

    Optional<Acquisition> getAcquisitionById(String id);
    
    Long getNextAcquisitionCountFromDatabase();
}

