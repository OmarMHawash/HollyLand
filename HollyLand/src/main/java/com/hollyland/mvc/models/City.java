package com.hollyland.mvc.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="cities")
public class City {
	//Fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String name;
	@OneToMany(mappedBy="city", fetch = FetchType.LAZY)
    private List<Village> villages;
	
	//Constructors
	public City() {
		
	}
	public City(String name) {
		this.name = name;
	}
	
	//GettersAndSetters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
}
