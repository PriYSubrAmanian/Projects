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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="productid")
	private int productid;

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
	
	@NotNull(message = "price can not be null")
	@Column(name="productbuying_price")
	private double product_buying_price;
	
	@NotBlank(message = "Product name can not be empty")
	@Size(max = 20,message = "Product name can't be more than 20 characters")
	@Column(name="productname")
	private String productname;
	@NotNull(message = "price can not be null")
	@Column(name="productselling_price")
	private double productselling_price;

	//bi-directional many-to-one association to Category
	
	@ManyToOne( cascade=CascadeType.MERGE)
	@JoinColumn(name="category_id",insertable=false,updatable=false)
	@JsonIgnore
	//@JoinColumn(name="categoryId")
	private Category category;

	//bi-directional many-to-one association to Stock
	//@OneToMany(mappedBy="product")
	@OneToMany( cascade=CascadeType.MERGE)
	@JoinColumn(name="productid",insertable=false,updatable=false)
	@JsonIgnore
	private List<Stock> stocks;

	public int getProductId() {
		return this.productid;
	}

	public void setProductId(int productId) {
		this.productid = productId;
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

	public double getProductbuyingPrice() {
		return this.product_buying_price;
	}

	public void setProductbuyingPrice(double productbuyingPrice) {
		this.product_buying_price = productbuyingPrice;
	}

	

	public String getProductName() {
		return this.productname;
	}

	public void setProductName(String productName) {
		this.productname = productName;
	}

	public double getProductsellingPrice() {
		return this.productselling_price;
	}

	public void setProductsellingPrice(double productsellingPrice) {
		this.productselling_price = productsellingPrice;
	}

	

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Stock> getStocks() {
		return this.stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public Stock addStock(Stock stock) {
		getStocks().add(stock);
		stock.setProduct(this);

		return stock;
	}

	public Stock removeStock(Stock stock) {
		getStocks().remove(stock);
		stock.setProduct(null);

		return stock;
	}

}
