package com.bob.jamserver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="door")
public class Door {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	private String type;
	private int hinges;
	private int screws;
	private double height;
	private double width;
	private String color;
	private int quantity;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="job_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	Job job;
	
	
	
	public Door() {}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public int getHinges() {
		return hinges;
	}



	public void setHinges(int hinges) {
		this.hinges = hinges;
	}



	public int getScrews() {
		return screws;
	}



	public void setScrews(int screws) {
		this.screws = screws;
	}



	public double getHeight() {
		return height;
	}



	public void setHeight(double height) {
		this.height = height;
	}



	public double getWidth() {
		return width;
	}



	public void setWidth(double width) {
		this.width = width;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public Job getJob() {
		return job;
	}



	public void setJob(Job job) {
		this.job = job;
	}
	
	

}
