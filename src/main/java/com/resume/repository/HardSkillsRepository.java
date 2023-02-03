package com.resume.repository;

import com.resume.model.HardSkillsModel;
import com.resume.model.SoftSkillsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HardSkillsRepository extends JpaRepository<HardSkillsModel, Long> {
    @Query("SELECT h FROM HardSkillsModel h JOIN User u ON u.id = h.user.id WHERE u.username = :username")
    List<HardSkillsModel> findSkillsByUsername(@Param("username") String username);
    @Query("SELECT h FROM HardSkillsModel h JOIN User u ON u.id = h.user.id WHERE u.username = :username AND h.id = :id")
    HardSkillsModel findByIdAndUsername(@Param("username") String username, @Param("id") Long id);
}
