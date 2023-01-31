package com.resume.model;

public class Education {
    private String titleDegree;
    private String career;
    private String description;
    private String institution;
    private Integer startYear;
    private Integer endYear;

    public String getTitleDegree() {
        return titleDegree;
    }

    public void setTitleDegree(String titleDegree) {
        this.titleDegree = titleDegree;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }
}
