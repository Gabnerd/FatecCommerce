/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fateccomerce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Gabriel Rodrigues
 */
public class ConnectionFactory {
    public static Connection getConnection() throws Exception{
        try{
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://motty.db.elephantsql.com:5432/svnjgsxr", "svnjgsxr", "5f9iaRuqyzwv8ofdvWstm5J-Rc3O4lic");
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    
    public static void close(Connection conn, Statement stmt, ResultSet rs) throws Exception{
        try{
            if(rs != null) rs.close();
            if(stmt != null) stmt.close();
            if(conn != null) conn.close();
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    
    public static void close(Connection conn, Statement stmt) throws Exception{
        close(conn, stmt, null);
    }
    public static void close(Connection conn) throws Exception{
        close(conn, null, null);
    }
}
