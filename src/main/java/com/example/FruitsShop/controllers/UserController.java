package com.example.FruitsShop.controllers;

import com.example.FruitsShop.service.user.UserFruitsService;
import com.example.FruitsShop.service.user.UserOrderService;
import com.example.FruitsShop.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    UserFruitsService service;

    @Autowired
    UserOrderService orderService;

    @GetMapping("/")
    public String getHome(Model model) {
        model.addAttribute("title", "Fruits Shop");
        model.addAttribute("fragmentName", "home");
        return "User/layout";
    }

    @GetMapping("/fruits")
    public String getFruits(Model model) {
        model.addAttribute("title", "Fruits");
        model.addAttribute("Fruits", service.getAll());
        model.addAttribute("fragmentName", "fruits");
        return "User/layout";
    }


    @GetMapping("/contacts")
    public String getContacts(Model model) {
        model.addAttribute("title", "Contacts");
        model.addAttribute("fragmentName", "contacts");
        return "User/layout";
    }

    @PostMapping("/order")
    public ResponseEntity<?> makeOrder(
            @RequestParam("userName") String userName,
            @RequestParam("userPhone") String userPhone,
            @RequestParam("userEmail") String userEmail,
            @RequestParam("userOrderMsg") String userOrderMsg) {

        String[] data = new String[]{userName, userPhone,
                userEmail, userOrderMsg};

        String orderCode;

        try {
            orderCode = orderService.makeOrder(data);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage(false,
                    "Error."), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new ResponseMessage(true,
                "Your order code is " + orderCode + ". Do not lost it, please."),
                HttpStatus.OK);
    }
}
