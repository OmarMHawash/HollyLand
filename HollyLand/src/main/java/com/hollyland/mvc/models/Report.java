package com.hollyland.mvc.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="reports")
public class Report {
	//Fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "report cannot be blank")
	private String report;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="village_id")
	private Village villageReport;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	//Constructors
	public Report() {
		
	}
	public Report(String report, Village villageReport) {
		this.report = report;
		this.villageReport = villageReport;
	}
	
	//GettersAndSetters
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	public Long getId() {
		return id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public Village getVillageReport() {
		return villageReport;
	}
	public void setVillageReport(Village village) {
		this.villageReport = village;
	}
	
	//Methods
	@PrePersist
	public void onCreate() {
		this.createdAt = new Date();
	}
}
