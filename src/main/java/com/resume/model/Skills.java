package com.resume.model;

import java.util.List;

public class Skills {
    private List<String> hardSkills;
    private List<String> softSkills;

    public void addSoftSkill(String softSkill) {
        softSkills.add(softSkill);
    }

    public void addHardSkill(String hardSkill) {
        hardSkills.add(hardSkill);
    }

    public List<String> getHardSkills() {
        return hardSkills;
    }

    public List<String> getSoftSkills() {
        return softSkills;
    }
}
