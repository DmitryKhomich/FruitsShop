package com.example.FruitsShop.service.admin;

import com.example.FruitsShop.entity.Fruit;
import com.example.FruitsShop.repo.FruitsRepository;
import com.example.FruitsShop.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class AdminFruitsService {

    @Autowired
    FruitsRepository fruitsRepository;

    public void createFruit(Fruit fruit) {
        fruitsRepository.save(fruit);
    }
    public List<Fruit> getAll() {
        Iterable<Fruit> iterable = fruitsRepository.findAll();
        List<Fruit> list =
                StreamSupport.stream(iterable.spliterator(), false)
                        .map(fruit -> new Fruit(fruit.getId(),
                                Constants.URL_IMAGES_UPLOADS + fruit.getImg(),
                                fruit.getName(),
                                fruit.getArticle(),
                                fruit.getDescr(),
                                fruit.getPrice()))
                        .toList();
        return new ArrayList<>(list);
    }
}
