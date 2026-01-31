package com.telecomsystem.controller;

import com.telecomsystem.model.Plan;
import com.telecomsystem.service.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @PostMapping("/plan")
    public Plan createPlan(@RequestBody Plan plan){
        return adminService.createPlan(plan);
    }

    @GetMapping("/plans")
    public List<Plan> getAllPlans(){
        return adminService.getAllPlans();
    }
}
