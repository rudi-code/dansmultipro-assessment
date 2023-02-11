package com.rps.dansmultipro.service;

import java.util.List;

import com.rps.dansmultipro.domain.Role;
import com.rps.dansmultipro.domain.User;

/**
 * @author rudi_
 * Feb 11, 2023
 */

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String role);
    User getUser(String username);
    List<User> getUsers();

}
