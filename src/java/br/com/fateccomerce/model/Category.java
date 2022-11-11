/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fateccomerce.model;

/**
 *
 * @author Gabriel Rodrigues
 */
public class Category {
    private Integer idCategory;
    private String nameCategory;
    private String descriptionCategory;

    public Category(String nameCategory, String descriptionCategory) {
        this.nameCategory = nameCategory;
        this.descriptionCategory = descriptionCategory;
    }

    public Category(Integer idCategory, String nameCategory, String descriptionCategory) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
        this.descriptionCategory = descriptionCategory;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getDescriptionCategory() {
        return descriptionCategory;
    }

    public void setDescriptionCategory(String descriptionCategory) {
        this.descriptionCategory = descriptionCategory;
    }
    
    
}
