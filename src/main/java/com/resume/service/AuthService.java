package com.resume.service;

import com.resume.model.Auth;
import com.resume.model.AuthBody;

public interface AuthService {
    Auth updateByUsername(String username, AuthBody auth);
}
