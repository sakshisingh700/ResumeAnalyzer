package com.resumeanalyzer.resumeanalyzer;

import java.util.ArrayList;
import java.util.List;

public class JobRecommendationService {

    public static List<String> recommendJobs(List<String> skills) {

        List<String> jobs = new ArrayList<>();

        if (skills.contains("java")) {
            jobs.add("Java Developer");
        }

        if (skills.contains("javascript")) {
            jobs.add("JavaScript Developer");
        }

        if (skills.contains("html") && skills.contains("css")) {
            jobs.add("Frontend Developer");
        }

        if (skills.contains("html")
                && skills.contains("css")
                && skills.contains("javascript")) {
            jobs.add("Web Developer");
        }

        if (skills.contains("sql")) {
            jobs.add("SQL Developer");
        }

        if (skills.contains("java")
                && skills.contains("sql")) {
            jobs.add("Software Developer");
        }

        if (skills.contains("react")
                && skills.contains("javascript")) {
            jobs.add("React Developer");
        }

        return jobs;
    }
}