package com.example.madan.madanhk;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
    private String name;
    private String description;
    private String vendor;
    private double price;
    private int stock;
    private String currency;
    private String imageUrl;
    private String sku;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Product(Long id, String name, String description, String vendor, double price, int stock, String currency, String imageUrl, String sku) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.vendor = vendor;
        this.price = price;
        this.stock = stock;
        this.currency = currency;
        this.imageUrl = imageUrl;
        this.sku = sku;


    }
}
