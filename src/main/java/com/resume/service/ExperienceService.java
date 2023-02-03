package com.resume.service;

import com.resume.model.EducationBody;
import com.resume.model.Experience;
import com.resume.model.ExperienceBody;
import com.resume.model.ExperienceModel;

import java.util.List;

public interface ExperienceService {
    List<Experience> updateByUsername(String username, List<ExperienceBody> educationList);
    List<Experience> findAllByUsername(String username);
    Experience findByIdAndUsername(String username, Long id);
    void removeById(Long id);
}
