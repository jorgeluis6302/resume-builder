package com.resume.repository;

import com.resume.model.SoftSkillsModel;
import com.resume.model.TechSkillsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechSkillsRepository extends JpaRepository<TechSkillsModel, Long> {
    @Query("SELECT t FROM TechSkillsModel t JOIN User u ON u.id = t.user.id WHERE u.username = :username")
    List<TechSkillsModel> findSkillsByUsername(@Param("username") String username);
    @Query("SELECT t FROM TechSkillsModel t JOIN User u ON u.id = t.user.id WHERE u.username = :username AND t.id = :id")
    TechSkillsModel findByIdAndUsername(@Param("username") String username, @Param("id") Long id);
}
