package com.management.security.services;

import com.management.security.entities.Role;
import com.management.security.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    User createUser(String username, String password, String email, String confirmPassword);
    Role createRole(String role);

    void addRoletoUser(String username, String role);
    void removeRolefromUser(String username, String role);

    User loadUserByUsername(String username);

}
