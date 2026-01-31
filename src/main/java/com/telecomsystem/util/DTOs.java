package com.telecomsystem.util;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DTOs {

    /**
     * Example DTO for creating a user
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UserDTO {
        private String username;
        private String email;
        private String password;
        private Long planId;
    }

    /**
     * Example DTO for creating a plan
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class PlanDTO {
        private String name;
        private double rate;
        private int dataLimit;
    }
}
