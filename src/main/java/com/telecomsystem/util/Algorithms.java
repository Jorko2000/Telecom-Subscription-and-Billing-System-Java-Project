package com.telecomsystem.util;

import com.telecomsystem.model.User;

import java.util.List;

public class Algorithms {

    /**
     * Example: Find top N users by data limit of their plan
     * Demonstrates sorting and sublist usage (algorithm + data structures)
     */
    public static List<User> topUsersByDataLimit(List<User> users, int n) {
        // Sort users descending by plan data limit
        users.sort((u1, u2) -> Integer.compare(u2.getPlan().getDataLimit(), u1.getPlan().getDataLimit()));
        // Return top N users or all if less than N
        return users.subList(0, Math.min(n, users.size()));
    }

    /**
     * Example: Calculate total revenue from a list of billings
     */
    public static double totalRevenue(List<Double> amounts){
        double total = 0;
        for(double amt : amounts){
            total += amt;
        }
        return total;
    }

    /**
     * Example: Search user by username (linear search)
     */
    public static User searchUserByUsername(List<User> users, String username){
        for(User u : users){
            if(u.getUsername().equalsIgnoreCase(username)){
                return u;
            }
        }
        return null; // not found
    }
}

