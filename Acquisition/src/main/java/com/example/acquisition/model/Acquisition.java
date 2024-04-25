package com.example.acquisition.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Acquisition {

    @Id
    private String id;
    
    @Column(name = "acquisition_date")
    @Temporal(TemporalType.DATE)
    private Date acquisitionDate;
    private String source;
    private String note;

    public Acquisition() {
    }

    public Acquisition(Date acquisitionDate, String source, String note) {
        this.acquisitionDate = acquisitionDate;
        this.source = source;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(Date acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
