/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fateccomerce.model;

/**
 *
 * @author Gabriel Rodrigues
 */
public class Brand {
    private Integer idBrand;
    private String nameBrand;
    private String descriptionBrand;

    public Brand(Integer idBrand, String nameBrand, String descriptionBrand) {
        this.idBrand = idBrand;
        this.nameBrand = nameBrand;
        this.descriptionBrand = descriptionBrand;
    }

    public Brand(String nameBrand, String descriptionBrand) {
        this.nameBrand = nameBrand;
        this.descriptionBrand = descriptionBrand;
    }

    public Integer getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(Integer idBrand) {
        this.idBrand = idBrand;
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }

    public String getDescriptionBrand() {
        return descriptionBrand;
    }

    public void setDescriptionBrand(String descriptionBrand) {
        this.descriptionBrand = descriptionBrand;
    }
    
}
