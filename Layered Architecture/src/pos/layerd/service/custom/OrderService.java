/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pos.layerd.service.custom;

import java.util.List;
import pos.layerd.dto.OrderDetailDto;
import pos.layerd.dto.OrderDto;
import pos.layerd.service.SuperService;

/**
 *
 * @author DELL i5
 */
public interface OrderService extends SuperService {

    String placeOrder(OrderDto orderDto) throws Exception;

    boolean checkQty(int qty, String itemId) throws Exception;

}
