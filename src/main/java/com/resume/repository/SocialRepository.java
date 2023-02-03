package com.resume.repository;

import com.resume.model.Social;
import com.resume.model.SocialModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocialRepository extends CrudRepository<SocialModel, Long> {
   @Query("SELECT s FROM SocialModel s JOIN User u ON u.id = s.user.id WHERE u.username = :username")
   List<SocialModel> findSocialsByUsername(@Param("username") String username);
   @Query("SELECT s FROM SocialModel s JOIN User u ON u.id = s.user.id WHERE u.username = :username AND s.id = :id")
   SocialModel findByIdAndUsername(@Param("username") String username, @Param("id") Long id);
}
