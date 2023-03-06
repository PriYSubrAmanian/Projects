package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
public class Invoice {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="invoice_id")
	private int invoice_id;
	
	@Column(name="product_id")
	private int product_id;
	
	@NotBlank(message = "Product name can not be empty")
	@Size(max = 20,message = "Product name can't be more than 20 characters")
	@Size(min=5, message="Product name must be more than 5 characters")
	
	@NotNull(message = "quantity can not be null")
	@Min(value=1000, message="quantity must be greater than 10")
	@Column(name="quantity")
	private double quantity;
    @Column(name="total")
	private double total;

	public Invoice() {
	}
	

	public Invoice(int invoiceId, int productId,
			@NotBlank(message = "Product name can not be empty") @Size(max = 20, message = "Product name can't be more than 20 characters") @Size(min = 5, message = "Product name must be more than 5 characters") @NotNull(message = "price can not be null") @Min(value = 1000, message = "quantity must be greater than 10") double quantity,
			double total) {
		super();
		this.invoice_id = invoiceId;
		this.product_id = productId;
		this.quantity = quantity;
		this.total = total;
	}


	public int getInvoiceId() {
		return this.invoice_id;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoice_id = invoiceId;
	}

	

	public int getProductId() {
		return this.product_id;
	}

	public void setProductId(int productId) {
		this.product_id = productId;
	}

	
	public double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	

	

	
}
