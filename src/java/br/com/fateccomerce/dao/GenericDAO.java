/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.fateccomerce.dao;

import java.util.List;

/**
 *
 * @author Gabriel Rodrigues
 */
public interface GenericDAO {
    public Boolean save(Object object);
    public List<Object> findAll();
    public void deleteById(Integer idObject);
    public Object findById(Integer idObject);
    public Boolean update(Object object);
}
