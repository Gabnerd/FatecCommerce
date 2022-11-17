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
public class BrandDAO implements GenericDAO {

    private Connection conn;

    public BrandDAO() {
        try {
            conn = ConnectionFactory.getConnection();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public Boolean save(Object object) {
        Brand brand = (Brand) object;
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("INSERT INTO Brand(name_brand, description_brand) VALUES(?, ?)");
            stmt.setString(1, brand.getNameBrand());
            stmt.setString(2, brand.getDescriptionBrand());
            int r = stmt.executeUpdate();
            return (r == 1);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.close(conn, stmt);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Object> findAll() {
        PreparedStatement stmt = null;
        List<Object> brands = new ArrayList<>();
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM Brand");
            rs = stmt.executeQuery();
            while (rs.next()) {
                brands.add(new Brand(Integer.parseInt(rs.getString("id_brand")), rs.getString("name_brand"), rs.getString("description_brand")));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                ConnectionFactory.close(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return brands;

    }

    @Override
    public void deleteById(Integer idObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object findById(Integer idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Brand brand = null;
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM Brand where id_brand=?");
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            rs.next();
            brand = new Brand(rs.getInt("id_brand"), rs.getString("name_brand"), rs.getString("description_brand"));
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                ConnectionFactory.close(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return brand;
    }

    @Override
    public Boolean update(Object object) {
        PreparedStatement stmt = null;
        Brand brand = (Brand) object;
        boolean ret = false;
        try {
            stmt = conn.prepareStatement("UPDATE Brand SET name_brand = ?, description_brand = ? WHERE id_brand = ?");
            stmt.setString(1, brand.getNameBrand());
            stmt.setString(2, brand.getDescriptionBrand());
            stmt.setInt(3, brand.getIdBrand());
            ret = (stmt.executeUpdate() == 1);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                ConnectionFactory.close(conn, stmt);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return ret;
    }

}
