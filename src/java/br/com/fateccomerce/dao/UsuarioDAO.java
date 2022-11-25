/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fateccomerce.dao;

import br.com.fateccomerce.model.Usuario;
import br.com.fateccomerce.util.ConnectionFactory;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Gabriel Rodrigues
 */
public class UsuarioDAO implements GenericDAO{

    private Connection conn;

    public UsuarioDAO() {
        try {
            conn = ConnectionFactory.getConnection();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    @Override
    public Boolean save(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Object> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    
    public Usuario login(String username, String password){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        try{
             MessageDigest md = MessageDigest.getInstance("SHA-512");
            stmt = conn.prepareStatement("SELECT * FROM Usuario WHERE username = ?");
            rs = stmt.executeQuery();
            rs.next();
            
            if(rs.getString("password").equals(new String(md.digest(password.getBytes())))){
                usuario = new Usuario(rs.getInt("id_usuario"), rs.getString("username"), rs.getString("nome_usuario"), rs.getInt("tipo_usuario"));
            }
        }catch(Exception e){
             System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
        }finally {
            try {
                ConnectionFactory.close(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return usuario;
    }
}
