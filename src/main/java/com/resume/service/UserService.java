package com.resume.service;

import com.resume.model.Profile;
import com.resume.model.ProfileBody;
import com.resume.model.User;

import java.util.List;

public interface UserService {
    User findByUsername(String username);
    User save(User user);
    List<User> findAll();

}
