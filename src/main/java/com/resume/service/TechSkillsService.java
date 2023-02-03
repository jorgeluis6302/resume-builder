package com.resume.service;

import com.resume.model.TechSkills;
import com.resume.model.TechSkillsBody;
import com.resume.model.TechSkillsModel;

import java.util.List;

public interface TechSkillsService {
    List<TechSkills> updateByUsername(String username, List<TechSkillsBody> skillsList);
    List<TechSkillsModel> findAllByUsername(String username);
    TechSkillsModel findByIdAndUsername(String username, Long id);
    void removeById(Long id);
}
