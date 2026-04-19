/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.cnt;
import edu.ijse.mvc.dto.Dto;
import edu.ijse.mvc.model.CustomerModel;
import java.sql.*;

/**
 *
 * @author ASUS
 */
public class controller {
    private CustomerModel model;
    
    
    public controller(){
        this.model=new CustomerModel();
    }
    
    public void savecust(Dto dto) throws Exception{
        model.save(dto);
    
    }
    
    public ResultSet load() throws Exception{
        return model.load();
    
    }
    
    public Dto loadcust(String id) throws SQLException, ClassNotFoundException{
        return model.loadcust(id);
    
    
    
    }

    public void update(Dto dto) throws SQLException, ClassNotFoundException {
        model.update(dto);
    }

    public void delete(Dto dto) throws SQLException, ClassNotFoundException {
        model.delete(dto);
    }
    
    
    
}
