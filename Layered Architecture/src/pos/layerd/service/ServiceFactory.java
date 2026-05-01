/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layerd.service;

import pos.layerd.service.custom.impl.CustomerServiceImpl;
import pos.layerd.service.custom.impl.ItemServiceImpl;
import pos.layerd.service.custom.impl.OrderServiceImpl;

/**
 *
 * @author DELL i5
 */
public class ServiceFactory {

    private static ServiceFactory serviceFactory;

    public static ServiceFactory getInstance() {
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactory();
        }

        return serviceFactory;
    }

    public SuperService getService(ServiceType type) {
        switch (type) {
            case CUSTOMER:
                return new CustomerServiceImpl();
            case ITEM:
                return new ItemServiceImpl();
            case ORDER:
                return new OrderServiceImpl();
            default:
                return null;
        }
    }

    public enum ServiceType {
        CUSTOMER, ITEM, ORDER
    }

}
