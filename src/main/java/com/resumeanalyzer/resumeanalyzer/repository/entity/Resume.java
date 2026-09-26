package com.resumeanalyzer.resumeanalyzer.repository.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "resumes")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    private Integer atsScore;

    @Column(columnDefinition = "TEXT")
    private String skills;

    @Column(columnDefinition = "TEXT")
    private String recommendedJobs;

    @Column(columnDefinition = "TEXT")
    private String missingSkills;

    @Column(columnDefinition = "TEXT")
    private String strengths;

    @Column(columnDefinition = "TEXT")
    private String suggestions;

    @Column(name = "selected_job_role")
    private String selectedJobRole;

    @Column(name = "job_match_score")
    private Integer jobMatchScore;

    public Resume() {
    }

    public Resume(String fileName,
                  Integer atsScore,
                  String skills,
                  String recommendedJobs,
                  String missingSkills,
                  String strengths,
                  String suggestions) {

        this.fileName = fileName;
        this.atsScore = atsScore;
        this.skills = skills;
        this.recommendedJobs = recommendedJobs;
        this.missingSkills = missingSkills;
        this.strengths = strengths;
        this.suggestions = suggestions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getAtsScore() {
        return atsScore;
    }

    public void setAtsScore(Integer atsScore) {
        this.atsScore = atsScore;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getRecommendedJobs() {
        return recommendedJobs;
    }

    public void setRecommendedJobs(String recommendedJobs) {
        this.recommendedJobs = recommendedJobs;
    }

    public String getMissingSkills() {
        return missingSkills;
    }

    public void setMissingSkills(String missingSkills) {
        this.missingSkills = missingSkills;
    }

    public String getStrengths() {
        return strengths;
    }

    public void setStrengths(String strengths) {
        this.strengths = strengths;
    }

    public String getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(String suggestions) {
        this.suggestions = suggestions;
    }

    public String getSelectedJobRole() {
        return selectedJobRole;
    }

    public void setSelectedJobRole(String selectedJobRole) {
        this.selectedJobRole = selectedJobRole;
    }

    public Integer getJobMatchScore() {
        return jobMatchScore;
    }

    public void setJobMatchScore(Integer jobMatchScore) {
        this.jobMatchScore = jobMatchScore;
    }
}

