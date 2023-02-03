package com.resume.repository;

import com.resume.model.Education;
import com.resume.model.EducationModel;
import com.resume.model.Experience;
import com.resume.model.ExperienceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceRepository extends JpaRepository<ExperienceModel, Long> {
    @Query("SELECT e FROM ExperienceModel e JOIN User u ON u.id = e.user.id WHERE u.username = :username")
    List<Experience> findAllByUsername(@Param("username") String username);
    @Query("SELECT e FROM ExperienceModel e JOIN User u ON u.id = e.user.id WHERE u.username = :username AND e.id = :id")
    Experience findByIdAndUsername(@Param("username") String username, @Param("id") Long id);
}
