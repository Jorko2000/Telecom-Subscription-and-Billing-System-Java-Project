package com.telecomsystem.service;

import com.telecomsystem.model.Plan;
import com.telecomsystem.repository.PlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final PlanRepository planRepository;

    public AdminService(PlanRepository planRepository){
        this.planRepository = planRepository;
    }

    public Plan createPlan(Plan plan){
        return planRepository.save(plan);
    }

    public List<Plan> getAllPlans(){
        return planRepository.findAll();
    }
}
