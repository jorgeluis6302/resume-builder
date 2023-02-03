package com.resume.service;

import com.resume.model.Auth;
import com.resume.model.AuthBody;
import com.resume.model.AuthModel;
import com.resume.model.User;
import com.resume.repository.AuthRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthRepository authRepository;
    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public Auth updateByUsername(String username, AuthBody authInfo) {
        User currentUser = userService.findByUsername(username);
        AuthModel auth = new AuthModel();
        auth.setAccessToken(authInfo.accessToken);
        auth.setRememberToken(authInfo.rememberToken);
        auth.setUser(currentUser);
        return authRepository.save(auth);
    }
}
