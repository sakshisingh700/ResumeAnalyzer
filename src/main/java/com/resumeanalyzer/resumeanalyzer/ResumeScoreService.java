package com.resumeanalyzer.resumeanalyzer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ResumeScoreService {

    public static int calculateScore(
            List<String> skills,
            String resumeText) {

        Map<String, Integer> breakdown =
                calculateBreakdown(skills, resumeText);

        int score = 0;

        for (int value : breakdown.values()) {
            score += value;
        }

        if (score > 100) {
            score = 100;
        }

        return score;
    }

    public static Map<String, Integer> calculateBreakdown(
            List<String> skills,
            String resumeText) {

        if (resumeText == null) {
            resumeText = "";
        }

        String text = resumeText.toLowerCase();

        Map<String, Integer> breakdown =
                new LinkedHashMap<>();

        String[] importantSkills = {
                "java",
                "javascript",
                "python",
                "html",
                "css",
                "sql",
                "react",
                "spring boot",
                "git",
                "github"
        };

        int matchedSkills = 0;

        if (skills != null) {

            for (String skill : importantSkills) {

                if (skills.contains(skill)) {
                    matchedSkills++;
                }
            }
        }

        int technicalSkills =
                (matchedSkills * 40)
                        / importantSkills.length;

        breakdown.put(
                "Technical Skills",
                technicalSkills
        );

        String[] sections = {
                "education",
                "skills",
                "projects",
                "experience"
        };

        int sectionCount = 0;

        for (String section : sections) {

            if (text.contains(section)) {
                sectionCount++;
            }
        }

        int resumeSections =
                (sectionCount * 20)
                        / sections.length;

        breakdown.put(
                "Resume Sections",
                resumeSections
        );

        int projects = 0;

        if (text.contains("project")
                || text.contains("projects")) {

            projects = 15;
        }

        breakdown.put(
                "Projects",
                projects
        );

        int education = 0;

        if (text.contains("education")
                || text.contains("mca")
                || text.contains("b.sc")
                || text.contains("bsc")) {

            education = 10;
        }

        breakdown.put(
                "Education",
                education
        );

        int contact = 0;

        boolean hasEmail =
                text.contains("@");

        boolean hasPhone =
                text.matches("(?s).*\\d{10}.*");

        if (hasEmail && hasPhone) {
            contact = 5;
        }

        breakdown.put(
                "Contact Information",
                contact
        );

        int achievements = 0;

        boolean hasNumbers =
                text.matches("(?s).*\\d+%.*")
                        || text.matches("(?s).*\\d+\\+.*")
                        || text.matches(
                        "(?s).*\\d+\\s*(years|months|users|projects).*"
                );

        if (hasNumbers) {
            achievements = 10;
        }

        breakdown.put(
                "Achievements",
                achievements
        );

        return breakdown;
    }
    public static List<String> findRoleBasedMissingSkills(
            String jobRole,
            List<String> skills) {

        String[] roleSkills;

        switch (jobRole) {

            case "Java Developer":
                roleSkills = new String[]{
                        "spring boot",
                        "hibernate",
                        "rest api"
                };
                break;

            case "Frontend Developer":
                roleSkills = new String[]{
                        "react",
                        "responsive design",
                        "ui/ux"
                };
                break;

            case "Software Developer":
                roleSkills = new String[]{
                        "spring boot",
                        "react",
                        "data structures"
                };
                break;

            case "Full Stack Developer":
                roleSkills = new String[]{
                        "react",
                        "spring boot",
                        "rest api"
                };
                break;

            case "Data Analyst":
                roleSkills = new String[]{
                        "excel",
                        "power bi",
                        "statistics",
                        "data visualization"
                };
                break;

            default:
                roleSkills = new String[]{};
        }

        List<String> missingSkills =
                new ArrayList<>();

        if (skills == null) {

            for (String skill : roleSkills) {
                missingSkills.add(skill);
            }

            return missingSkills;
        }

        for (String skill : roleSkills) {

            if (!skills.contains(skill)) {
                missingSkills.add(skill);
            }
        }

        return missingSkills;
    }

}