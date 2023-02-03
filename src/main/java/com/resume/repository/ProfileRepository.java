package com.resume.repository;

import com.resume.model.Profile;
import com.resume.model.ProfileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileModel, Long> {
    @Query("SELECT p FROM ProfileModel p JOIN User u ON u.id = p.user.id WHERE u.username = :username")
    Profile findByUsername(@Param("username") String username);
}
