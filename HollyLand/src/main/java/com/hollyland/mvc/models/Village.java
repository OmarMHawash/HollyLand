package com.hollyland.mvc.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="villages")
public class Village {
	//Fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String name;
	@NotEmpty
	private float space;
	@NotEmpty
	private int populdation;
	@NotEmpty
	private String description;
	
	@OneToMany(mappedBy="villageImage", fetch = FetchType.LAZY)
	private List<Image> images;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="city_id")
	private City city;
	
	@OneToMany(mappedBy="villageReport", fetch = FetchType.LAZY)
	private List<Report> reports;
	
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	//Constructors
	public Village() {
		
	}
	public Village(String name, float space, int population, String description, City city) {
		this.name = name;
		this.space = space;
		this.populdation = population;
		this.description = description;
		this.city = city;
	}
	
	//GettersAndSetters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSpace() {
		return space;
	}
	public void setSpace(float space) {
		this.space = space;
	}
	public int getPopuldation() {
		return populdation;
	}
	public void setPopuldation(int populdation) {
		this.populdation = populdation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public List<Report> getReports() {
		return reports;
	}
	public void setReports(List<Report> reports) {
		this.reports = reports;
	}
	
	//Methods
	@PrePersist
	public void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = new Date();
	}
	
}
