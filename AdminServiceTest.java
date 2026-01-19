package com.telecomsystem;

import com.telecomsystem.model.Plan;
import com.telecomsystem.repository.PlanRepository;
import com.telecomsystem.service.AdminService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AdminServiceTest {

    private PlanRepository planRepository = mock(PlanRepository.class);
    private AdminService adminService = new AdminService(planRepository);

    @Test
    public void testCreatePlan() {
        Plan plan = new Plan(null, "Basic", 0.5, 1000);
        when(planRepository.save(plan)).thenReturn(new Plan(1L, "Basic", 0.5, 1000));

        Plan created = adminService.createPlan(plan);
        assertNotNull(created.getId());
        assertEquals("Basic", created.getName());
    }

    @Test
    public void testGetAllPlans() {
        List<Plan> plans = Arrays.asList(
                new Plan(1L, "Basic", 0.5, 1000),
                new Plan(2L, "Premium", 1.0, 5000)
        );

        when(planRepository.findAll()).thenReturn(plans);

        List<Plan> result = adminService.getAllPlans();
        assertEquals(2, result.size());
        assertEquals("Premium", result.get(1).getName());
    }
}
