package com.example.FruitsShop.controllers;

import com.example.FruitsShop.service.admin.AdminFruitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminFruitsService service;

    @GetMapping
    public String getHome(Model model) {
        model.addAttribute("title", "Fruits Shop");
        model.addAttribute("fragmentName", "home");
        return "Admin/layout";
    }

    @GetMapping("/fruits")
    public String getFruits(Model model) {
        model.addAttribute("title", "Fruits");
        model.addAttribute("Fruits", service.getAll());
        model.addAttribute("fragmentName", "fruits");
        return "Admin/layout";
    }
}
