package com.hollyland.mvc.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="messages")
public class Message {
	//Fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String message;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	//Constructors
	public Message() {
		
	}
	public Message(String message) {
		this.message = message;
	}
	
	//GettersAndSetters
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getId() {
		return id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	
	//Methods
	@PrePersist
	public void onCreate() {
		this.createdAt = new Date();
	}
}
