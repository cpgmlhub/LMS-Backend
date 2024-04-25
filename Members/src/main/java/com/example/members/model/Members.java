package com.example.members.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Members {

    @Id
    private String id;
    private String name;
    private String email;
    private String department;

    // Constructors
    public Members() {
    }

    public Members(String name, String email, String department) {
        this.name = name;
        this.email= email;
        this.department = department;
    }

    // Getters and setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
		this.id = id;
	}
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
