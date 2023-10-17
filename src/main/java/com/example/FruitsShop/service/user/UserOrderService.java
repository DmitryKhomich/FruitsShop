package com.example.FruitsShop.service.user;

import com.example.FruitsShop.entity.Order;
import com.example.FruitsShop.repo.OrdersRepository;
import com.example.FruitsShop.utils.StringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserOrderService {

    @Autowired
    OrdersRepository repository;

    public String makeOrder(String[] data) {
        String orderCode = StringGenerator.genStr();
        Order order = new Order();
        order.setUserName(data[0]);
        order.setUserPhone(data[1]);
        order.setUserEmail(data[2]);
        order.setContent(data[3]);
        order.setOrderCode(orderCode);
        repository.save(order);
        return orderCode;
    }
}
