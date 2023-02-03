package com.resume.service;

import com.resume.model.*;
import com.resume.repository.EducationRepository;
import com.resume.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EducationServiceImpl implements EducationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EducationRepository educationRepository;

    @Override
    @Transactional
    public List<Education> updateByUsername(String username, List<EducationBody> educationList) {
        User currentUser = userRepository.findByUsername(username);
        List<Education> educations = new ArrayList<>();
        for (EducationBody educationItem : educationList) {
            EducationModel education = new EducationModel();
            education.setCareer(educationItem.career);
            education.setInstitution(educationItem.institution);
            education.setDescription(educationItem.description);
            education.setTitleDegree(educationItem.titleDegree);
            education.setStartYear(educationItem.startYear);
            education.setEndYear(educationItem.endYear);
            education.setUser(currentUser);
            educationRepository.save(education);
            educations.add(education);
        }
        return educations;
    }

    @Override
    public List<EducationModel> findAllByUsername(String username) {
        return educationRepository.findAllByUsername(username);
    }

    @Override
    public Education findByIdAndUsername(String username, Long id) {
        return educationRepository.findByIdAndUsername(username, id);
    }

    @Override
    @Transactional
    public void removeById(Long id) {
        educationRepository.deleteById(id);
    }
}
