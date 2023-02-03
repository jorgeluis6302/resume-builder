package com.resume.service;

import com.resume.model.*;

import java.util.List;

public interface HardSkillsService {
    List<Skills> updateByUsername(String username, List<SkillsBody> skillsList);
    List<HardSkillsModel> findAllByUsername(String username);
    HardSkillsModel findByIdAndUsername(String username, Long id);
    void removeById(Long id);
}
