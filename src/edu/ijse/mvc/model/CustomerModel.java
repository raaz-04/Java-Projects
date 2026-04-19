/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.model;

import java.sql.*;
import edu.ijse.mvc.db.DBConnection;
import edu.ijse.mvc.dto.Dto;

/**
 *
 * @author ASUS
 */
public class CustomerModel {

    public void save(Dto dto) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Customer VALUES(?,?,?,?)";
        Connection connection = DBConnection.getinstance().getconnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, dto.getId());
        statement.setString(2, dto.getName());
        statement.setString(3, dto.getAddress());
        statement.setString(4, dto.getContact());
        int result = statement.executeUpdate();
        System.out.println(result > 0 ? "Success" : "Fail");
    }

    public ResultSet load() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Customer";
        Connection connection = DBConnection.getinstance().getconnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rst = statement.executeQuery();
        return rst;

    }

    public Dto loadcust(String id) throws SQLException, ClassNotFoundException {
        Dto dto = new Dto();
        String sql = "SELECT * FROM Customer WHERE id=?";
        Connection connection = DBConnection.getinstance().getconnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, id);
        ResultSet rst = statement.executeQuery();
        while(rst.next()){;
            dto.setAddress(rst.getString("address"));
            dto.setName(rst.getString("name"));
            dto.setId(rst.getString("id"));
            dto.setContact(rst.getString("contact"));
        }
        return dto;
    }

    public void update(Dto dto) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Customer SET name=?,contact=?,address=? WHERE id=?";
        Connection connection = DBConnection.getinstance().getconnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(4, dto.getId());
        statement.setString(1, dto.getName());
        statement.setString(2, dto.getContact());
        statement.setString(3, dto.getAddress());
        statement.executeUpdate();
    }

    public void delete(Dto dto) throws SQLException, ClassNotFoundException {
        String sql = "Delete from Customer WHERE id=?";
        Connection connection = DBConnection.getinstance().getconnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, dto.getId());
        statement.executeUpdate();
    }
}
