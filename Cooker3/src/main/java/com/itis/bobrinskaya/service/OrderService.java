package com.itis.bobrinskaya.service;

import com.itis.bobrinskaya.model.Orders;
import com.itis.bobrinskaya.model.Productinorder;

import java.util.List;

/**
 * Created by Ekaterina on 29.04.2016.
 */

public interface OrderService {
    /**
     *
     * @return all orders
     */
    List<Orders> getAll();

    /**
     *
     * @return orders with status false
     */
    List<Orders> getNotReady();

    /**
     *
     * @return orders with status true
     */
    List<Orders> getReady();

    /**
     *
     * @param order
     * @return adds or updates order in DB
     */
    Orders createNewOrder(Orders order);

    /**
     *
     * @param productinorder
     * @return adds prodicts to order
     */
    Productinorder addproducts(Productinorder productinorder);

    /**
     *
     * @param id
     * @return id of user's last order
     */
    int getUsersLastOrder(int id);

    /**
     *
     * @param id
     * @return one order by id
     */
    Orders getOne(int id);
}
