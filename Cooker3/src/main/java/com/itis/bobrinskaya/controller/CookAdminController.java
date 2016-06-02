package com.itis.bobrinskaya.controller;

import com.itis.bobrinskaya.model.Orders;
import com.itis.bobrinskaya.service.OrderService;
import com.itis.bobrinskaya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ekaterina on 29.04.2016.
 */
@Controller
@RequestMapping(value = "/cookadmin")
public class CookAdminController {
    @Autowired
    OrderService orderService;
   @Autowired
    UserService userService;

    /**
     *
     * @return cookadmin page
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getCookPage(){
        return "cookadmin";
    }

    /**
     *
     * @param checkbox
     * @param orderId
     * @return cookadmin page with selected order status changed
     */
    @RequestMapping(method = RequestMethod.POST)
    public String changeStatus(@RequestParam String checkbox, @RequestParam int orderId){
        if (checkbox != null){
            Orders order = orderService.getOne(orderId);
            order.setStatus(true);
            orderService.createNewOrder(order);
        }

        return "redirect:/cookadmin";
    }

    /**
     *
     * @param select
     * @return sends data to ajax
     */
    @RequestMapping(value = "/toajax", method = RequestMethod.GET)
    public @ResponseBody
    List<Orders> makeJSon(@RequestParam String select){
        List<Orders> orders = new ArrayList<>();
        switch (select){
            case "notready": orders = orderService.getNotReady();
                break;
            case "ready" : orders =  orderService.getReady();
                break;
            case "all" : orders =  orderService.getAll();
                break;
        }


        return orders;
    }

}
