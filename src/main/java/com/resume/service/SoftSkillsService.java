package com.resume.service;

import com.resume.model.*;

import java.util.List;

public interface SoftSkillsService {
    List<Skills> updateByUsername(String username, List<SkillsBody> skillsList);
    List<SoftSkillsModel> findAllByUsername(String username);
    SoftSkillsModel findByIdAndUsername(String username, Long id);
    void removeById(Long id);
}
