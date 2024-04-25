package com.example.library.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Circulation {

    @Id
    private String id;
    
    
    private String memberId;
    
    @Temporal(TemporalType.DATE)
    private Date issueDate;
    
    @Temporal(TemporalType.DATE)
    private Date dueDate;
    
    private String item;
    
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}

    // Constructors, getters, and setters
}
