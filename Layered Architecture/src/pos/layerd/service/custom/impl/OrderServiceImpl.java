/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layerd.service.custom.impl;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import pos.layerd.dao.DaoFactory;
import pos.layerd.dao.custom.ItemDao;
import pos.layerd.dao.custom.OrderDao;
import pos.layerd.dao.custom.OrderDetailDao;
import pos.layerd.db.DBConnection;
import pos.layerd.dto.OrderDetailDto;
import pos.layerd.dto.OrderDto;
import pos.layerd.entity.ItemEntity;
import pos.layerd.entity.OrderDetailEntity;
import pos.layerd.entity.OrderEntity;
import pos.layerd.service.custom.OrderService;

/**
 *
 * @author DELL i5
 */
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = (OrderDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ORDER);
    private OrderDetailDao orderDetailDao = (OrderDetailDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ORDER_DETAIL);
    private ItemDao itemDao = (ItemDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ITEM);

    @Override
    public String placeOrder(OrderDto dto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            if (orderDao.add(new OrderEntity(dto.getOrderId(), sdf.format(new Date()), dto.getCustomerId()))) {

                boolean isOrderSaved = true;
                for (OrderDetailDto orderDetailDto : dto.getOrderDetailDtos()) {
                    if (!orderDetailDao.add(new OrderDetailEntity(dto.getOrderId(),
                            orderDetailDto.getItemId(),
                            orderDetailDto.getQty(),
                            orderDetailDto.getDiscount()))) {
                        isOrderSaved = false;
                    }
                }

                if (isOrderSaved) {

                    boolean isItemUpdated = true;
                    for (OrderDetailDto orderDetailDto : dto.getOrderDetailDtos()) {
                        ItemEntity itemEntity = itemDao.get(orderDetailDto.getItemId());
                        itemEntity.setQoh(itemEntity.getQoh() - orderDetailDto.getQty());
                        if (!itemDao.update(itemEntity)) {
                            isItemUpdated = false;
                        }
                    }

                    if (isItemUpdated) {

                        connection.commit();
                        return "Success";

                    } else {
                        connection.rollback();
                        return "Item Update Error";
                    }

                } else {
                    connection.rollback();
                    return "Order Detail Save Error";
                }

            } else {
                connection.rollback();
                return "Order Save Error";
            }

        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public boolean checkQty(int qty, String itemId) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();

        ItemEntity ie = itemDao.get(itemId);
        if (ie.getQoh() >= qty) {
            return true;
        } else {
            return false;
        }
    }

}
