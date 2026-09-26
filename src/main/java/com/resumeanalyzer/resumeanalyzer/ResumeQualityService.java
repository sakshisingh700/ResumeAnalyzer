package com.resumeanalyzer.resumeanalyzer;

import java.util.ArrayList;
import java.util.List;

public class ResumeQualityService {

    public static List<String> findStrengths(
            String jobRole,
            List<String> skills) {

        List<String> strengths = new ArrayList<>();

        if (skills == null) {
            return strengths;
        }

        switch (jobRole) {

            case "Java Developer":

                if (skills.contains("java")) {
                    strengths.add("Java programming knowledge");
                }

                if (skills.contains("sql")) {
                    strengths.add("Database and SQL knowledge");
                }

                if (skills.contains("git")
                        && skills.contains("github")) {
                    strengths.add(
                            "Version control knowledge using Git and GitHub"
                    );
                }

                break;

            case "Frontend Developer":

                if (skills.contains("javascript")) {
                    strengths.add("JavaScript knowledge");
                }

                if (skills.contains("html")
                        && skills.contains("css")) {
                    strengths.add(
                            "Good foundation in HTML and CSS"
                    );
                }

                if (skills.contains("git")
                        && skills.contains("github")) {
                    strengths.add(
                            "Version control knowledge using Git and GitHub"
                    );
                }

                break;

            case "Software Developer":

                if (skills.contains("java")) {
                    strengths.add("Java programming knowledge");
                }

                if (skills.contains("javascript")) {
                    strengths.add("JavaScript knowledge");
                }

                if (skills.contains("sql")) {
                    strengths.add("Database and SQL knowledge");
                }

                if (skills.contains("git")
                        && skills.contains("github")) {
                    strengths.add(
                            "Version control knowledge using Git and GitHub"
                    );
                }

                break;

            case "Full Stack Developer":

                if (skills.contains("javascript")) {
                    strengths.add("JavaScript knowledge");
                }

                if (skills.contains("html")
                        && skills.contains("css")) {
                    strengths.add(
                            "Good foundation in HTML and CSS"
                    );
                }

                if (skills.contains("java")) {
                    strengths.add("Java programming knowledge");
                }

                if (skills.contains("sql")) {
                    strengths.add("Database and SQL knowledge");
                }

                if (skills.contains("git")) {
                    strengths.add(
                            "Version control knowledge using Git"
                    );
                }

                break;

            case "Data Analyst":

                if (skills.contains("python")) {
                    strengths.add("Python programming knowledge");
                }

                if (skills.contains("sql")) {
                    strengths.add("Database and SQL knowledge");
                }

                break;
        }

        return strengths;
    }


    public static List<String> findSuggestions(
            String jobRole,
            List<String> skills) {

        List<String> suggestions = new ArrayList<>();

        if (skills == null) {
            skills = new ArrayList<>();
        }

        switch (jobRole) {

            case "Java Developer":

                if (!skills.contains("spring boot")) {
                    suggestions.add(
                            "Learn Spring Boot for Java backend development"
                    );
                }

                break;

            case "Frontend Developer":

                if (!skills.contains("react")) {
                    suggestions.add(
                            "Learn React.js for modern frontend development"
                    );
                }

                break;

            case "Software Developer":

                if (!skills.contains("spring boot")) {
                    suggestions.add(
                            "Learn Spring Boot for Java backend development"
                    );
                }

                if (!skills.contains("react")) {
                    suggestions.add(
                            "Learn React.js for modern frontend development"
                    );
                }

                break;

            case "Full Stack Developer":

                if (!skills.contains("react")) {
                    suggestions.add(
                            "Learn React.js for frontend development"
                    );
                }

                if (!skills.contains("spring boot")) {
                    suggestions.add(
                            "Learn Spring Boot for backend development"
                    );
                }

                break;

            case "Data Analyst":

                if (!skills.contains("python")) {
                    suggestions.add(
                            "Learn Python for data analysis"
                    );
                }

                if (!skills.contains("excel")) {
                    suggestions.add(
                            "Learn Microsoft Excel for data analysis"
                    );
                }

                if (!skills.contains("power bi")) {
                    suggestions.add(
                            "Learn Power BI for data visualization"
                    );
                }

                if (!skills.contains("statistics")) {
                    suggestions.add(
                            "Strengthen statistics fundamentals"
                    );
                }

                break;
        }

        suggestions.add(
                "Add measurable achievements to your projects"
        );

        suggestions.add(
                "Keep project descriptions clear and concise"
        );

        return suggestions;
    }
}