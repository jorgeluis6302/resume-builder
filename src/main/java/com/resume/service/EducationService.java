package com.resume.service;

import com.resume.model.Education;
import com.resume.model.EducationBody;
import com.resume.model.EducationModel;

import java.util.List;

public interface EducationService {
    List<Education> updateByUsername(String username, List<EducationBody> educationList);
    List<EducationModel> findAllByUsername(String username);
    Education findByIdAndUsername(String username, Long id);
    void removeById(Long id);
}
