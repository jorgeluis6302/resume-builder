package com.resume.service;

import com.resume.model.*;
import com.resume.repository.TechSkillsRepository;
import com.resume.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TechSkillsServiceImpl implements TechSkillsService {
    @Autowired
    private TechSkillsRepository techSkillsRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<TechSkills> updateByUsername(String username, List<TechSkillsBody> skillsList) {
        User currentUser = userRepository.findByUsername(username);
        List<TechSkills> skills = new ArrayList<>();
        for (TechSkillsBody skillItem : skillsList) {
            TechSkillsModel skill = new TechSkillsModel();
            skill.setTech(skillItem.tech);
            skill.setDescription(skillItem.description);
            skill.setUser(currentUser);
            techSkillsRepository.save(skill);
            skills.add(skill);
        }
        return skills;
    }

    @Override
    public List<TechSkillsModel> findAllByUsername(String username) {
        return techSkillsRepository.findSkillsByUsername(username);
    }

    @Override
    public TechSkillsModel findByIdAndUsername(String username, Long id) {
        return techSkillsRepository.findByIdAndUsername(username, id);
    }

    @Override
    public void removeById(Long id) {
        techSkillsRepository.deleteById(id);
    }
}
