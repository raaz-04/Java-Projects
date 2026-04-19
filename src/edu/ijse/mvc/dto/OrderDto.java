/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.dto;

/**
 *
 * @author ASUS
 */
public class OrderDto {
    private String custid;
    private String orderid;
    private String itemid;
    private String quanity;

    /**
     * @return the custid
     */
    public String getCustid() {
        return custid;
    }

    /**
     * @param custid the custid to set
     */
    public void setCustid(String custid) {
        this.custid = custid;
    }

    /**
     * @return the orderid
     */
    public String getOrderid() {
        return orderid;
    }

    /**
     * @param orderid the orderid to set
     */
    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    /**
     * @return the itemid
     */
    public String getItemid() {
        return itemid;
    }

    /**
     * @param itemid the itemid to set
     */
    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    @Override
    public String toString() {
        return "OrderDto{" + "custid=" + custid + ", orderid=" + orderid + ", itemid=" + itemid + '}';
    }

    /**
     * @return the quanity
     */
    public String getQuanity() {
        return quanity;
    }

    /**
     * @param quanity the quanity to set
     */
    public void setQuanity(String quanity) {
        this.quanity = quanity;
    }
    
    
    
    
    
}
