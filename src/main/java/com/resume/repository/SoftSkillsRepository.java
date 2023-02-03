package com.resume.repository;

import com.resume.model.SocialModel;
import com.resume.model.SoftSkillsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SoftSkillsRepository extends JpaRepository<SoftSkillsModel, Long> {
    @Query("SELECT s FROM SoftSkillsModel s JOIN User u ON u.id = s.user.id WHERE u.username = :username")
    List<SoftSkillsModel> findSkillsByUsername(@Param("username") String username);
    @Query("SELECT s FROM SoftSkillsModel s JOIN User u ON u.id = s.user.id WHERE u.username = :username AND s.id = :id")
    SoftSkillsModel findByIdAndUsername(@Param("username") String username, @Param("id") Long id);
}
