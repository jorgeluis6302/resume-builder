package com.resume.controller;

import com.resume.model.*;
import com.resume.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProfileService profileService;
    @Autowired
    private AuthService authService;
    @Autowired
    private SocialService socialService;
    @Autowired
    private EducationService educationService;
    @Autowired
    private ExperienceService experienceService;
    @Autowired
    private SoftSkillsService softSkillsService;
    @Autowired
    private HardSkillsService hardSkillsService;
    @Autowired
    private TechSkillsService techSkillsService;

    // User endpoints.

    @GetMapping("/")
    public List<User> listUsers() {
       List<User> response = userService.findAll();
       return response;
    }

    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        User response = userService.save(user);
        return response;
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        User response = userService.findByUsername(username);
        return response;
    }

    // Profile endpoints

    @PostMapping("/{username}/profile")
    public Profile modifyProfile(
            @PathVariable("username") String username,
            @RequestBody ProfileBody profile) {
        return profileService.updateByUsername(username, profile);
    }

    @GetMapping("/{username}/profile")
    public Profile getProfile(@PathVariable("username") String username) {
        return profileService.findByUsername(username);
    }

    // Auth endpoints

    @PutMapping("/{username}/auth")
    public Auth modifyAuth(
            @PathVariable("username") String username,
            @RequestBody AuthBody auth) {
        return authService.updateByUsername(username, auth);
    }

    // Social endpoints

    @PutMapping("/{username}/social")
    public List<Social> modifySocials(
            @PathVariable("username") String username,
            @RequestBody List<SocialBody> socialsList
    ) {
        return socialService.updateByUsername(username, socialsList);
    }

    @GetMapping("/{username}/social")
    public List<SocialModel> getSocials(
            @PathVariable("username") String username
    ) {
        return socialService.findAllByUsername(username);
    }

    @GetMapping("/{username}/social/{id}")
    public Social getSocial(
            @PathVariable("username") String username,
            @PathVariable("id") Long id
    ) {
        return socialService.findByIdAndUsername(username, id);
    }

    @DeleteMapping("/{username}/social/{id}")
    public void removeSocial(
            @PathVariable("username") String username,
            @PathVariable("id") Long id
    ) {
        socialService.removeById(id);
    }

    // Education endpoints.

    @PutMapping("/{username}/education")
    public List<Education> modifyEducation(
            @PathVariable("username") String username,
            @RequestBody List<EducationBody> educationList
    ) {
        return educationService.updateByUsername(username, educationList);
    }

    @GetMapping("/{username}/education")
    public List<EducationModel> getEducations(
            @PathVariable("username") String username
    ) {
        return educationService.findAllByUsername(username);
    }

    @GetMapping("/{username}/education/{id}")
    public Education getEducation(
            @PathVariable("username") String username,
            @PathVariable("id") Long id
    ) {
        return educationService.findByIdAndUsername(username, id);
    }

    @DeleteMapping("/{username}/education/{id}")
    public void deleteEducation(
            @PathVariable("username") String username,
            @PathVariable("id") Long id
    ) {
        educationService.removeById(id);
    }

    // Experience endpoints

    @PutMapping("/{username}/experience")
    public List<Experience> modifyExperience(
            @PathVariable("username") String username,
            @RequestBody List<ExperienceBody> experienceList
    ) {
        return experienceService.updateByUsername(username, experienceList);
    }

    @GetMapping("/{username}/experience")
    public List<Experience> getExperiences(
            @PathVariable("username") String username
    ) {
        return experienceService.findAllByUsername(username);
    }

    @GetMapping("/{username}/experience/{id}")
    public Experience getExperience(
            @PathVariable("username") String username,
            @PathVariable("id") Long id
    ) {
        return experienceService.findByIdAndUsername(username, id);
    }

    @DeleteMapping("/{username}/experience/{id}")
    public void deleteExperience(
            @PathVariable("username") String username,
            @PathVariable("id") Long id
    ) {
        experienceService.removeById(id);
    }

    // Soft skills endpoints

    @PutMapping("/{username}/soft-skills")
    public List<Skills> updateSoftSkills(
            @PathVariable("username") String username,
            @RequestBody List<SkillsBody> skillsList) {
        return softSkillsService.updateByUsername(username, skillsList);
    }

    @GetMapping("/{username}/soft-skills")
    public List<SoftSkillsModel> getSoftSkills(
            @PathVariable("username") String username) {
        return softSkillsService.findAllByUsername(username);
    }

    @GetMapping("/{username}/soft-skills/{id}")
    public Skills getSoftSkill(
            @PathVariable("username") String username,
            @PathVariable("id") Long id
    ) {
        return softSkillsService.findByIdAndUsername(username, id);
    }

    @DeleteMapping("/{username}/soft-skills/{id}")
    public void deleteSoftSkill(
            @PathVariable("username") String username,
            @PathVariable("id") Long id
    ) {
        softSkillsService.removeById(id);
    }

    // Hard Skills endpoints

    @PutMapping("/{username}/hard-skills")
    public List<Skills> updateHardSkills(
            @PathVariable("username") String username,
            @RequestBody List<SkillsBody> skillsList) {
        return hardSkillsService.updateByUsername(username, skillsList);
    }

    @GetMapping("/{username}/hard-skills")
    public List<HardSkillsModel> getHardSkills(
            @PathVariable("username") String username) {
        return hardSkillsService.findAllByUsername(username);
    }

    @GetMapping("/{username}/hard-skills/{id}")
    public Skills getHardSkill(
            @PathVariable("username") String username,
            @PathVariable("id") Long id
    ) {
        return hardSkillsService.findByIdAndUsername(username, id);
    }
    @DeleteMapping("/{username}/hard-skills/{id}")
    public void deleteHardSkill(
            @PathVariable("username") String username,
            @PathVariable("id") Long id
    ) {
        hardSkillsService.removeById(id);
    }

    // Tech skills

    @PutMapping("/{username}/hard-skills")
    public List<TechSkills> updateTechSkills(
            @PathVariable("username") String username,
            @RequestBody List<TechSkillsBody> skillsList) {
        return techSkillsService.updateByUsername(username, skillsList);
    }

    @GetMapping("/{username}/hard-skills")
    public List<TechSkillsModel> getTechSkills(
            @PathVariable("username") String username) {
        return techSkillsService.findAllByUsername(username);
    }

    @GetMapping("/{username}/hard-skills/{id}")
    public TechSkills getTechSkill(
            @PathVariable("username") String username,
            @PathVariable("id") Long id
    ) {
        return techSkillsService.findByIdAndUsername(username, id);
    }
    @DeleteMapping("/{username}/hard-skills/{id}")
    public void deleteTechSkill(
            @PathVariable("username") String username,
            @PathVariable("id") Long id
    ) {
        techSkillsService.removeById(id);
    }

}