package com.telecomsystem.service;

import com.telecomsystem.model.Billing;
import com.telecomsystem.model.User;
import com.telecomsystem.repository.BillingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingService {

    private final BillingRepository billingRepository;

    public BillingService(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    public Billing calculateBill(User user, int usageMinutes) {
        double rate = user.getPlan().getRate();
        double total = rate * usageMinutes;

        Billing billing = new Billing();
        billing.setUser(user);
        billing.setAmount(total);

        return billingRepository.save(billing);
    }

    public List<Billing> getAllBills() {
        return billingRepository.findAll();
    }
}
