package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;



@Entity
public class Pricing {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pricing_id")
	private int pricing_id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date_time")
	private Date created_date_time;
	@NotEmpty(message = "user name should not be empty")
	@Column(name="created_user")
	private String created_user;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_modified_date_time")
	private Date last_modified_date_time;
	@NotEmpty(message = "user name should not be empty")
	@Column(name="last_modified_user")
	private String last_modified_user;

	
	public Pricing() {
	}


	public Pricing(int pricing_id, Date created_date_time,
			@NotEmpty(message = "user name should not be empty") String created_user, Date last_modified_date_time,
			@NotEmpty(message = "user name should not be empty") String last_modified_user) {
		super();
		this.pricing_id = pricing_id;
		this.created_date_time = created_date_time;
		this.created_user = created_user;
		this.last_modified_date_time = last_modified_date_time;
		this.last_modified_user = last_modified_user;
	}


	public int getPricing_id() {
		return pricing_id;
	}


	public void setPricing_id(int pricing_id) {
		this.pricing_id = pricing_id;
	}


	public Date getCreated_date_time() {
		return created_date_time;
	}


	public void setCreated_date_time(Date created_date_time) {
		this.created_date_time = created_date_time;
	}


	public String getCreated_user() {
		return created_user;
	}


	public void setCreated_user(String created_user) {
		this.created_user = created_user;
	}


	public Date getLast_modified_date_time() {
		return last_modified_date_time;
	}


	public void setLast_modified_date_time(Date last_modified_date_time) {
		this.last_modified_date_time = last_modified_date_time;
	}


	public String getLast_modified_user() {
		return last_modified_user;
	}


	public void setLast_modified_user(String last_modified_user) {
		this.last_modified_user = last_modified_user;
	}

	
	

	
	

	

}
