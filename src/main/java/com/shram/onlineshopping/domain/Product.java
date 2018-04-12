package com.shram.onlineshopping.domain;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private  String code;
    private String name;
    private String brand;
    @JsonIgnore
    private String description;

    @Column(name="unit_price")
    private String unitPrice;
    private int quantity;

    @Column(name= "is_active")
    @JsonIgnore
    private boolean active;

    @Column(name="category_id")
    @JsonIgnore
    private int categoryId;
    @Column(name="supplier_id")
    private int supplierId;
    private int purchases;
    private int views;

    //default constructor. It provides the code with some random values
    public Product(){

    }

    public Product(String name, String brand, String description, String unitPrice, int quantity, boolean active, int categoryId, int supplierId, int purchases, int views) {
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.active = active;
        this.categoryId = categoryId;
        this.supplierId = supplierId;
        this.purchases = purchases;
        this.views = views;
        this.code= "PRD"+UUID.randomUUID().toString().substring(30).toUpperCase();
    }

    /*
        * getters and setters
        * */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getPurchases() {
        return purchases;
    }

    public void setPurchases(int purchases) {
        this.purchases = purchases;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }


    @Override
    public String toString() {
        return "\nProduct{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                ", quantity=" + quantity +
                ", active=" + active +
                ", categoryId=" + categoryId +
                ", supplierId=" + supplierId +
                ", purchases=" + purchases +
                ", views=" + views +
                '}';
    }
}
