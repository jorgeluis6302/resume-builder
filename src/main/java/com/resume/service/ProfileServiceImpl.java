package com.resume.service;

import com.resume.model.Profile;
import com.resume.model.ProfileBody;
import com.resume.model.ProfileModel;
import com.resume.model.User;
import com.resume.repository.ProfileRepository;
import com.resume.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public Profile updateByUsername(String username, ProfileBody profileInfo) {
        User currentUser = userRepository.findByUsername(username);
        ProfileModel profile = new ProfileModel();
        profile.setLocation(profileInfo.location);
        profile.setPhoneNumber(profileInfo.phoneNumber);
        profile.setProfileTitle(profileInfo.profileTitle);
        profile.setUser(currentUser);
        return profileRepository.save(profile);
    }

    @Override
    public Profile findByUsername(String username) {
        return profileRepository.findByUsername(username);
    }
}
