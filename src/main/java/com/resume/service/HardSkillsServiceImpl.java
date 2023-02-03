package com.resume.service;

import com.resume.model.*;
import com.resume.repository.HardSkillsRepository;
import com.resume.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HardSkillsServiceImpl implements HardSkillsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HardSkillsRepository hardSkillsRepository;

    @Override
    public List<Skills> updateByUsername(String username, List<SkillsBody> skillsList) {
        User currentUser = userRepository.findByUsername(username);
        List<Skills> skills = new ArrayList<>();
        for (SkillsBody skillItem : skillsList) {
            HardSkillsModel skill = new HardSkillsModel();
            skill.setSkill(skillItem.skill);
            skill.setUser(currentUser);
            hardSkillsRepository.save(skill);
            skills.add(skill);
        }
        return skills;
    }

    @Override
    public List<HardSkillsModel> findAllByUsername(String username) {
        return hardSkillsRepository.findSkillsByUsername(username);
    }

    @Override
    public HardSkillsModel findByIdAndUsername(String username, Long id) {
        return hardSkillsRepository.findByIdAndUsername(username, id);
    }

    @Override
    public void removeById(Long id) {
        hardSkillsRepository.deleteById(id);
    }
}
