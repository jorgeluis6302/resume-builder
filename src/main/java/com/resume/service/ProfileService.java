package com.resume.service;

import com.resume.model.Profile;
import com.resume.model.ProfileBody;

public interface ProfileService {
    Profile updateByUsername(String username, ProfileBody profileInfo);
    Profile findByUsername(String username);
}
