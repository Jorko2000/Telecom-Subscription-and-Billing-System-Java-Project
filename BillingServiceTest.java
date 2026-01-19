package com.telecomsystem;

import com.telecomsystem.model.Billing;
import com.telecomsystem.model.Plan;
import com.telecomsystem.model.User;
import com.telecomsystem.repository.BillingRepository;
import com.telecomsystem.service.BillingService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BillingServiceTest {

    private BillingRepository billingRepository = mock(BillingRepository.class);
    private BillingService billingService = new BillingService(billingRepository);

    @Test
    public void testCalculateBill() {
        Plan plan = new Plan(1L, "Basic", 0.5, 1000);
        User user = new User(1L, "john", "john@example.com", "pass123", plan);

        Billing expectedBilling = new Billing();
        expectedBilling.setUser(user);
        expectedBilling.setAmount(5.0);

        when(billingRepository.save(any(Billing.class))).thenReturn(expectedBilling);

        Billing result = billingService.calculateBill(user, 10);
        assertEquals(5.0, result.getAmount());
        assertEquals("john", result.getUser().getUsername());
    }
}
