/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.model;

import edu.ijse.mvc.db.DBConnection;
import edu.ijse.mvc.dto.Dto;
import edu.ijse.mvc.dto.OrderDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class OrderModel {

    public ResultSet search(OrderDto dto) throws SQLException, ClassNotFoundException {
        String sql = "select name,address,contact from customer where id = ? ";
        Connection connection = DBConnection.getinstance().getconnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, dto.getCustid());
        ResultSet result = statement.executeQuery();
        return result;

    }

    public ResultSet searchItem(OrderDto dto) throws SQLException, ClassNotFoundException {
        String sql = "select item_name,price,stock  from item where item_id = ? ";
        Connection connection = DBConnection.getinstance().getconnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, dto.getItemid());
        ResultSet result = statement.executeQuery();
        return result;
    }

    public void update(OrderDto dto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getinstance().getconnection();
        connection.setAutoCommit(false);
        try {
            PreparedStatement statement;
            String sql = "INSERT INTO orders VALUES(?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, dto.getOrderid());
            statement.setString(2, dto.getCustid());
            statement.setString(3, LocalDate.now().toString());
            int rst = statement.executeUpdate();
            if (rst > 0) {
                sql = "update item set stock= stock - ? where item_id = ?";
                statement = connection.prepareStatement(sql);
                statement.setString(1, dto.getQuanity());
                statement.setString(2, dto.getItemid());
                if (statement.executeUpdate() > 0) {
                    sql = "INSERT INTO order_item VALUES(?,?,?)";
                    statement = connection.prepareStatement(sql);
                    statement.setString(2, dto.getItemid());
                    statement.setString(1, dto.getOrderid());
                    statement.setString(3, dto.getQuanity());

                    if (statement.executeUpdate() > 0) {
                        connection.commit();
                    }
                }
            } else {
                connection.rollback();
            }

        } catch (Exception ex) {
            Logger.getLogger(OrderModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.setAutoCommit(true);
        }

    }
}
