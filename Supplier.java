package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Supplier {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="supplier_id")
	private int supplier_id;

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
	@NotEmpty(message = "Company name should not be empty")
	@Column(name="supplier_company")
	private String supplier_company;
	@NotNull(message = "Contact can not be null")
	@Column(name="supplier_contact")
	private int supplier_contact;
	@NotEmpty(message = "supplier name should not be empty")
	@Column(name="supplier_name")
	private String supplier_name;

	

	//bi-directional many-to-one association to Stock
	
	@OneToMany( cascade=CascadeType.MERGE)
	@JoinColumn(name="supplier_id",insertable=false,updatable=false)
	@JsonIgnore
	private List<Stock> stocks;

	public Supplier() {
	}

	public int getSupplierId() {
		return this.supplier_id;
	}

	public void setSupplierId(int supplierId) {
		this.supplier_id = supplierId;
	}

	public Date getCreatedDateTime() {
		return this.created_date_time;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.created_date_time = createdDateTime;
	}

	public String getCreatedUser() {
		return this.created_user;
	}

	public void setCreatedUser(String createdUser) {
		this.created_user = createdUser;
	}

	public Date getLastModifiedDateTime() {
		return this.last_modified_date_time;
	}

	public void setLastModifiedDateTime(Date lastModifiedDateTime) {
		this.last_modified_date_time = lastModifiedDateTime;
	}

	public String getLastModifiedUser() {
		return this.last_modified_user;
	}

	public void setLastModifiedUser(String lastModifiedUser) {
		this.last_modified_user = lastModifiedUser;
	}

	public String getSupplierCompany() {
		return this.supplier_company;
	}

	public void setSupplierCompany(String supplierCompany) {
		this.supplier_company = supplierCompany;
	}

	public int getSupplierContact() {
		return this.supplier_contact;
	}

	public void setSupplierContact(int supplierContact) {
		this.supplier_contact = supplierContact;
	}

	public String getSupplierName() {
		return this.supplier_name;
	}

	public void setSupplierName(String supplierName) {
		this.supplier_name = supplierName;
	}

	

	public List<Stock> getStocks() {
		return this.stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public Stock addStock(Stock stock) {
		getStocks().add(stock);
		stock.setSupplier(this);

		return stock;
	}

	public Stock removeStock(Stock stock) {
		getStocks().remove(stock);
		stock.setSupplier(null);

		return stock;
	}

}
