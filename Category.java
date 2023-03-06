package com.example.demo.entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="category_id")
	private int category_id;
	@NotBlank(message = "Category name can not be empty")
	@Size(max = 20,message = "Category name can't be more than 20 characters")
	@Size(min=5, message="Category name must be more than 5 characters")
	@Column(name="category_name")
	private String category_name;

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

	

	//bi-directional many-to-one association to Product
	//@OneToMany(mappedBy="category")
	//@OneToMany(targetEntity=Category.class,fetch=FetchType.EAGER)
	//@JoinColumn(name="category_id",insertable=false,updatable=false)
	@OneToMany( cascade=CascadeType.MERGE)
	@JoinColumn(name="category_id",insertable=false,updatable=false)
	@JsonIgnore
	private List<Product> products;

	//bi-directional many-to-one association to Stock
	//@OneToMany(mappedBy="category")
	@OneToMany( cascade=CascadeType.MERGE)
	@JoinColumn(name="category_id",insertable=false,updatable=false)
	@JsonIgnore
	private List<Stock> stocks;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(
			@NotBlank(message = "Category name can not be empty") @Size(max = 20, message = "Category name can't be more than 20 characters") @Size(min = 5, message = "Category name must be more than 5 characters") String categoryName,
			Date createdDateTime, @NotEmpty(message = "user name should not be empty") String createdUser,
			Date lastModifiedDateTime, @NotEmpty(message = "user name should not be empty") String lastModifiedUser,
			List<Product> products, List<Stock> stocks) {
		super();
		this.category_name = categoryName;
		this.created_date_time = createdDateTime;
		this.created_user = createdUser;
		this.last_modified_date_time = lastModifiedDateTime;
		this.last_modified_user = lastModifiedUser;
		this.products = products;
		this.stocks = stocks;
	}

	public int getCategoryId() {
		return this.category_id;
	}

	public String getCategoryName() {
		return this.category_name;
	}

	public void setCategoryName(String categoryName) {
		this.category_name = categoryName;
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

	

	public void setCategoryId(int categoryId) {
		this.category_id = categoryId;
	}

	
	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public Product addCategory(Product product) {
		getProducts().add(product);
		product.setCategory(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setCategory(null);

		return product;
	}

	public List<Stock> getStocks() {
		return this.stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public Stock addStock(Stock stock) {
		getStocks().add(stock);
		stock.setCategory(this);

		return stock;
	}

	public Stock removeStock(Stock stock) {
		getStocks().remove(stock);
		stock.setCategory(null);

		return stock;
	}

	


}
