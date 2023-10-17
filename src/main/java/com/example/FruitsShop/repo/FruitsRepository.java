package com.example.FruitsShop.repo;

import com.example.FruitsShop.entity.Fruit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface FruitsRepository extends CrudRepository<Fruit, Long> {
    List<Fruit> findAll();
}
