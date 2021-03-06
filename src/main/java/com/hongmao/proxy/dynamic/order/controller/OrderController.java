package com.hongmao.proxy.dynamic.order.controller;

import com.hongmao.proxy.dynamic.order.service.IOrderService;
import com.hongmao.proxy.dynamic.order.service.impl.OrderServiceImpl;
import com.hongmao.proxy.dynamic.common.ProxyFactory;
import com.hongmao.proxy.dynamic.common.TransactionalInvocationHandler;
import com.hongmao.proxy.dynamic.order.model.OrderDTO;

/**
 * @author haodong.zhao
 * @version 1.0. Added Time:2019/3/31 18:26
 */
public class OrderController {

    public static void main(String[] args) {
        IOrderService orderService = (IOrderService) ProxyFactory.getProxy(
                OrderServiceImpl.class,
                new TransactionalInvocationHandler(new OrderServiceImpl()));

        try {
            Long id = orderService.save(new OrderDTO());
            System.out.println("id : " + id);
            orderService.update(66L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
