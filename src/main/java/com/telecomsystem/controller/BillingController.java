package com.telecomsystem.controller;

import com.telecomsystem.model.Billing;
import com.telecomsystem.model.User;
import com.telecomsystem.service.BillingService;
import com.telecomsystem.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billing")
public class BillingController {

    private final BillingService billingService;
    private final UserService userService;

    public BillingController(BillingService billingService, UserService userService){
        this.billingService = billingService;
        this.userService = userService;
    }

    @PostMapping("/calculate/{userId}")
    public Billing calculate(@PathVariable Long userId, @RequestParam int minutes){
        User user = userService.getUserById(userId);
        return billingService.calculateBill(user, minutes);
    }

    @GetMapping("/all")
    public List<Billing> getAllBills(){
        return billingService.getAllBills();
    }
}
