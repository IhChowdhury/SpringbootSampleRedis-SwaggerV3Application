package com.ibrahim.redis.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Product")
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1234567L;
	
    @Schema(description = "Unique Identifier of the Contact.", example = "1",required = true)
    @Id
    private int id;
    @Schema(description = "Name of the product",example = "Smartphone", required = true)
    private String name;
    @Schema(description = "Quantity of the product",example = "20", required = true)
    private int qty;
    @Schema(description = "Price of the product",example = "1500", required = true)
    private long price;
    
    
	public Product() {
	}
	public Product(int id, String name, int qty, long price) {
		super();
		this.id = id;
		this.name = name;
		this.qty = qty;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
    
    
    
}
