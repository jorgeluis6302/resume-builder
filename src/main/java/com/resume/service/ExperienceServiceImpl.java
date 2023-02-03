package com.resume.service;

import com.resume.model.*;
import com.resume.repository.ExperienceRepository;
import com.resume.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExperienceServiceImpl implements ExperienceService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ExperienceRepository experienceRepository;

    @Override
    public List<Experience> updateByUsername(String username, List<ExperienceBody> experienceList) {
        User currentUser = userRepository.findByUsername(username);
        List<Experience> experiences = new ArrayList<>();
        for (ExperienceBody experienceItem : experienceList) {
            ExperienceModel experience = new ExperienceModel();
            experience.setCompany(experienceItem.company);
            experience.setDescription(experienceItem.description);
            experience.setLocation(experienceItem.location);
            experience.setPosition(experienceItem.position);
            experience.setStartYear(experienceItem.startYear);
            experience.setEndYear(experienceItem.endYear);
            experience.setUser(currentUser);
            experienceRepository.save(experience);
            experiences.add(experience);
        }
        return experiences;
    }

    @Override
    public List<Experience> findAllByUsername(String username) {
        return experienceRepository.findAllByUsername(username);
    }

    @Override
    public Experience findByIdAndUsername(String username, Long id) {
        return experienceRepository.findByIdAndUsername(username, id);
    }

    @Override
    public void removeById(Long id) {
        experienceRepository.deleteById(id);
    }
}
