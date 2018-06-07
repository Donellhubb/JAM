package com.bob.jamserver.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "job")
public class Job {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long id;
   
   private String time;
   private String description;
   @ManyToOne(fetch= FetchType.LAZY)
   @JoinColumn(name = "user_id")
   User user;
   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="customer_id")
   Customer customer;
   
   public Job() {
	   
   }


   public User getUser() {
	return user;
}


public void setUser(User user) {
	this.user = user;
}


public String getDescription() {
	return description;
}
   
public void setDescription(String description) {
	this.description = description;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}


   public Long getId() {
       return id;
   }

   public void setId(Long id) {
       this.id = id;
   }

   public String getTime() {
       return time;
   }

   public void setTime(String time) {
       this.time = time;
   }

   

   

}
