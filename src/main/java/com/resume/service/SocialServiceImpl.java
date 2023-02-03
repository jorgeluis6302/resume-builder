package com.resume.service;

import com.resume.model.Social;
import com.resume.model.SocialBody;
import com.resume.model.SocialModel;
import com.resume.model.User;
import com.resume.repository.SocialRepository;
import com.resume.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SocialServiceImpl implements SocialService {
    @Autowired
    private SocialRepository socialRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public List<Social> updateByUsername(String username, List<SocialBody> socialsList) {
        User currentUser = userRepository.findByUsername(username);
        List<Social> socials = new ArrayList<>();
        for (SocialBody socialItem : socialsList) {
            SocialModel social = new SocialModel();
            social.setUrl(socialItem.url);
            social.setName(socialItem.name);
            social.setAlias(socialItem.alias);
            social.setUser(currentUser);
            socials.add(social);
            socialRepository.save(social);
        }
        return socials;
    }

    @Override
    public List<SocialModel> findAllByUsername(String username) {
        return socialRepository.findSocialsByUsername(username);
    }

    @Override
    public SocialModel findByIdAndUsername(String username, Long id) {
        return socialRepository.findByIdAndUsername(username, id);
    }

    @Override
    @Transactional
    public void removeById(Long id) {
        socialRepository.deleteById(id);
    }
}
