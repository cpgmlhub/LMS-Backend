package com.example.library.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Catalogue {

    @Id
    private String id;

    private String name;
    private String description;
    private String author;
    private String category;

    // Constructor, getters, and setters
    
    // Constructors
    public Catalogue() {
    }
    

    public Catalogue(String name, String description, String author, String category) {
        this.name = name;
        this.description = description;
        this.author = author;
        this.category = category;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

	
}
