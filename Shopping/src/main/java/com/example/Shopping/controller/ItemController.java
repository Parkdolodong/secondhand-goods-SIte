package com.example.Shopping.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {
    @GetMapping("/item_reg")
    public String itemReg() {
        return "item/item_reg";
    }
}
