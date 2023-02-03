package com.resume.service;

import com.resume.model.*;
import com.resume.repository.SoftSkillsRepository;
import com.resume.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SoftSkillsServiceImpl implements SoftSkillsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SoftSkillsRepository softSkillsRepository;

    @Override
    public List<Skills> updateByUsername(String username, List<SkillsBody> skillsList) {
        User currentUser = userRepository.findByUsername(username);
        List<Skills> skills = new ArrayList<>();
        for (SkillsBody skillItem : skillsList) {
            SoftSkillsModel skill = new SoftSkillsModel();
            skill.setSkill(skillItem.skill);
            skill.setUser(currentUser);
            softSkillsRepository.save(skill);
            skills.add(skill);
        }
        return skills;
    }

    @Override
    public List<SoftSkillsModel> findAllByUsername(String username) {
        return softSkillsRepository.findSkillsByUsername(username);
    }

    @Override
    public SoftSkillsModel findByIdAndUsername(String username, Long id) {
        return softSkillsRepository.findByIdAndUsername(username, id);
    }

    @Override
    public void removeById(Long id) {
        softSkillsRepository.deleteById(id);
    }
}
