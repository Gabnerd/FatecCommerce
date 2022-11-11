/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fateccomerce.dao;

import br.com.fateccomerce.model.Brand;
import br.com.fateccomerce.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel Rodrigues
 */
public class BrandDAO implements GenericDAO{
    
    private Connection conn;

    public BrandDAO() {
        try{
            conn = ConnectionFactory.getConnection();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public Boolean save(Object object) {
        Brand brand = (Brand) object;
        PreparedStatement stmt = null;
        try{
            stmt = conn.prepareStatement("INSERT INTO Brand(name_brand, description_brand) VALUES(?, ?)");
            stmt.setString(1, brand.getNameBrand());
            stmt.setString(2, brand.getDescriptionBrand());
            int r = stmt.executeUpdate();
            return (r == 1);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
            return false;
        }finally{
            try{
                ConnectionFactory.close(conn, stmt);
            }catch(Exception e){
                System.out.println("Error: "+e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Object> findAll() {
        PreparedStatement stmt = null;
        try{
            stmt = conn.prepareStatement("SELECT * FROM Brand");
            ResultSet rs = stmt.executeQuery();
            List<Object> brands = new ArrayList<>();
            while(rs.next()){
                brands.add(new Brand(Integer.parseInt(rs.getString("id_brand")), rs.getString("name_brand"), rs.getString("description_brand")));
            }
            return brands;
        }catch(Exception e){
             System.out.println("Error: "+e.getMessage());
                e.printStackTrace();
                return new ArrayList<>();
        }finally{
            try{
                ConnectionFactory.close(conn, stmt);
            }catch(Exception e){
                System.out.println("Error: "+e.getMessage());
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public void deleteById(Integer idObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object findById(Integer idObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
