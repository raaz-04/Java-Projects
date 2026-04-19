/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.cnt;

import edu.ijse.mvc.dto.OrderDto;
import edu.ijse.mvc.model.OrderModel;
import java.sql.*;
/**
 *
 * @author ASUS
 */
public class OrderController {
        private OrderModel model;
    
    
    public OrderController(){
        this.model=new OrderModel();
    }
    
    public ResultSet search(OrderDto dto) throws Exception{
        return model.search(dto);
    
    }

    public ResultSet searchItem(OrderDto dto) throws SQLException, ClassNotFoundException {
        return model.searchItem(dto);
    }

    public void update(OrderDto dto) {
        model.update(dto);
    }


}
