package com.example.FruitsShop.repo;

import com.example.FruitsShop.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends CrudRepository<Order, Long> {
}
