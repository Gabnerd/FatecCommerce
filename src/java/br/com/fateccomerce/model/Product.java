/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fateccomerce.model;

/**
 *
 * @author Gabriel Rodrigues
 */
public class Product {
    private Integer idProduct;
    private String nameProduct;
    private String descriptionProduct;
    private Double cstPriceProduct;
    private Double salePriceProduct;
    private Brand brand;
    private Category category;

    public Product(Integer idProduct, String nameProduct, String descriptionProduct, Double cstPriceProduct, Double salePriceProduct, Brand brand, Category category) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.descriptionProduct = descriptionProduct;
        this.cstPriceProduct = cstPriceProduct;
        this.salePriceProduct = salePriceProduct;
        this.brand = brand;
        this.category = category;
    }

    public Product(String nameProduct, String descriptionProduct, Double cstPriceProduct, Double salePriceProduct, Brand brand, Category category) {
        this.nameProduct = nameProduct;
        this.descriptionProduct = descriptionProduct;
        this.cstPriceProduct = cstPriceProduct;
        this.salePriceProduct = salePriceProduct;
        this.brand = brand;
        this.category = category;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public Double getCstPriceProduct() {
        return cstPriceProduct;
    }

    public void setCstPriceProduct(Double cstPriceProduct) {
        this.cstPriceProduct = cstPriceProduct;
    }

    public Double getSalePriceProduct() {
        return salePriceProduct;
    }

    public void setSalePriceProduct(Double salePriceProduct) {
        this.salePriceProduct = salePriceProduct;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    
}
