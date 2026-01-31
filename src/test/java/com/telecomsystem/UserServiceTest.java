package com.telecomsystem;

import com.telecomsystem.model.Plan;
import com.telecomsystem.model.User;
import com.telecomsystem.repository.UserRepository;
import com.telecomsystem.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    private UserRepository userRepository = mock(UserRepository.class);
    private UserService userService = new UserService(userRepository);

    @Test
    public void testCreateUser() {
        User user = new User(null, "john", "john@example.com", "pass123", new Plan());
        when(userRepository.save(user)).thenReturn(new User(1L, "john", "john@example.com", "pass123", new Plan()));

        User created = userService.createUser(user);
        assertNotNull(created.getId());
        assertEquals("john", created.getUsername());
    }

    @Test
    public void testGetUserById_Found() {
        User user = new User(1L, "john", "john@example.com", "pass123", new Plan());
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User found = userService.getUserById(1L);
        assertEquals("john", found.getUsername());
    }

    @Test
    public void testGetUserById_NotFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            userService.getUserById(1L);
        });

        assertEquals("User not found", exception.getMessage());
    }
}
