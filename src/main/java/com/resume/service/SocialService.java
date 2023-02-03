package com.resume.service;

import com.resume.model.Social;
import com.resume.model.SocialBody;
import com.resume.model.SocialModel;

import java.util.List;

public interface SocialService {
    List<Social> updateByUsername(String username, List<SocialBody> socialsList);
    List<SocialModel> findAllByUsername(String username);
    SocialModel findByIdAndUsername(String username, Long id);
    void removeById(Long id);
}
