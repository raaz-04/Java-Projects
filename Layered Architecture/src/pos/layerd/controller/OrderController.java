/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layerd.controller;

import pos.layerd.dto.OrderDto;
import pos.layerd.service.ServiceFactory;
import pos.layerd.service.custom.OrderService;

/**
 *
 * @author DELL i5
 */
public class OrderController {

    private OrderService orderService = (OrderService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ORDER);

    public String placeOrder(OrderDto orderDto) throws Exception {
        return orderService.placeOrder(orderDto);
    }

    public boolean checkQty(int qty, String itemId) throws Exception {
        return orderService.checkQty(qty, itemId);
    }

}
