/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.db;
import java.sql.*;
/**
 *
 * @author ASUS
 */
public class DBConnection {
    private static DBConnection dbconnection;
    private Connection connection;
    
    private DBConnection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket", "root", "rasula123");
        
    }
    public static DBConnection getinstance() throws SQLException, ClassNotFoundException{
        if (dbconnection==null){
            dbconnection=new DBConnection();
        }
        return dbconnection;
        
        }
    public Connection getconnection(){
        return connection;
    }
    
    }

