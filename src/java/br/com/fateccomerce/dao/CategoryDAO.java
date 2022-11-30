/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fateccomerce.dao;

import br.com.fateccomerce.model.Category;
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
public class CategoryDAO implements GenericDAO {

    private Connection conn;

    public CategoryDAO() {
        try {
            conn = ConnectionFactory.getConnection();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public Boolean save(Object object) {
        Category category = (Category) object;
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO Category(name_category, description_category) VALUES(?,?)");
            stmt.setString(1, category.getNameCategory());
            stmt.setString(2, category.getDescriptionCategory());
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
        List<Object> categories = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM Category");
            rs = stmt.executeQuery();
            while (rs.next()) {
                categories.add(new Category(rs.getInt("id_category"), rs.getString("name_category"), rs.getString("description_category")));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.getStackTrace();
        } finally {
            try {
                ConnectionFactory.close(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                e.getStackTrace();
            }
        }
        return categories;
    }

    @Override
    public void deleteById(Integer idObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object findById(Integer idObject) {
        Category category = new Category();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM Category Where id_category = ?");
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            if (rs.next()) {
                category = new Category(rs.getInt("id_category"), rs.getString("name_category"), rs.getString("description_category"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.getStackTrace();
        } finally {
            try {
                ConnectionFactory.close(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                e.getStackTrace();
            }
        }
        return category;
    }

    @Override
    public Boolean update(Object object) {
        Category category = (Category) object;
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("UPDATE Category SET name_category = ?, description_category = ? WHERE id_category = ?");
            stmt.setString(1, category.getNameCategory());
            stmt.setString(2, category.getDescriptionCategory());
            stmt.setInt(3, category.getIdCategory());
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

}
