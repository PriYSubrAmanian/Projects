package com.example.demo.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Stock {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ref_id")
	private int ref_id;
	@NotEmpty(message = "Id should not be empty")
	@Column(name="branch_id")
	private String branch_id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date_time")
	private Date created_date_time;
	@NotEmpty(message = "user name should not be empty")
	@Column(name="created_user")
	private String created_user;

	@Temporal(TemporalType.DATE)
	@Column(name="date_stock")
	private Date date_stock;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_modified_date_time")
	private Date last_modified_date_time;
	@NotEmpty(message = "user name should not be empty")
	@Column(name="last_modified_user")
	private String last_modified_user;
	@NotNull(message = "price can not be null")
	@Column(name="quantity")
	private int quantity;

	//bi-directional many-to-one association to Product
	@ManyToOne( cascade=CascadeType.MERGE)
	@JoinColumn(name="productid",insertable=false,updatable=false)
	@JsonIgnore
	private Product product;

	//bi-directional many-to-one association to Supplier
	@ManyToOne( cascade=CascadeType.MERGE)
	@JoinColumn(name="supplier_id",insertable=false,updatable=false)
	@JsonIgnore
	private Supplier supplier;

	//bi-directional many-to-one association to Category
	@ManyToOne( cascade=CascadeType.MERGE)
	@JoinColumn(name="category_id",insertable=false,updatable=false)
	@JsonIgnore
	private Category category;

	public Stock() {
	}

	public Stock(int ref_id, @NotEmpty(message = "Id should not be empty") String branch_id, Date created_date_time,
			@NotEmpty(message = "user name should not be empty") String created_user, Date date_stock,
			Date last_modified_date_time,
			@NotEmpty(message = "user name should not be empty") String last_modified_user,
			@NotNull(message = "price can not be null") int quantity, Product product, Supplier supplier,
			Category category) {
		super();
		this.ref_id = ref_id;
		this.branch_id = branch_id;
		this.created_date_time = created_date_time;
		this.created_user = created_user;
		this.date_stock = date_stock;
		this.last_modified_date_time = last_modified_date_time;
		this.last_modified_user = last_modified_user;
		this.quantity = quantity;
		this.product = product;
		this.supplier = supplier;
		this.category = category;
	}

	public int getRef_id() {
		return ref_id;
	}

	public void setRef_id(int ref_id) {
		this.ref_id = ref_id;
	}

	public String getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
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

	public Date getDate_stock() {
		return date_stock;
	}

	public void setDate_stock(Date date_stock) {
		this.date_stock = date_stock;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
	/*public int getStockId() {
		return this.stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}*/

	

}
