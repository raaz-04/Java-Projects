/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layerd.dto;

import java.util.List;

/**
 *
 * @author DELL i5
 */
public class OrderDto {
    
    private String orderId;
    private String customerId;
    private List<OrderDetailDto> orderDetailDtos;

    public OrderDto() {
    }

    public OrderDto(String orderId, String customerId, List<OrderDetailDto> orderDetailDtos) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDetailDtos = orderDetailDtos;
    }

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the orderDetailDtos
     */
    public List<OrderDetailDto> getOrderDetailDtos() {
        return orderDetailDtos;
    }

    /**
     * @param orderDetailDtos the orderDetailDtos to set
     */
    public void setOrderDetailDtos(List<OrderDetailDto> orderDetailDtos) {
        this.orderDetailDtos = orderDetailDtos;
    }

    @Override
    public String toString() {
        return "OrderDto{" + "orderId=" + orderId + ", customerId=" + customerId + ", orderDetailDtos=" + orderDetailDtos + '}';
    }
    
}
