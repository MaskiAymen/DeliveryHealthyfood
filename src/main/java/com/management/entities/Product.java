package com.management.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;



@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    @NotNull
    @Size(min = 3, max = 20)
    private String nameProduct;
    @Min(10)
    @Max(10000)
    private Double priceProduct;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private Date dateCreate;

    private Double fat;

    private Double calories;
    private Double protein;
    private String description;



    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", nameProduct='" + nameProduct + '\'' +
                ", priceProduct=" + priceProduct +
                ", dateCreate=" + dateCreate +
                ",fat=" + fat +
                ", calories=" + calories +
                ", protein=" + protein +
                ", description='" + description + '\'' +
                '}';
    }

    public Product(String nameProduct, Double priceProduct, Date dateCreate ,Double fat,Double calories,String description, Double protein) {
        super();
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.dateCreate = dateCreate;
        this.fat = fat;
        this.calories = calories;
        this.protein = protein;
        this.description = description;
    }

    public Product() {
        super();
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }
    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
