package com.resumeanalyzer.resumeanalyzer;

import java.util.ArrayList;
import java.util.List;

public class ResumeAnalyzer {

    public static List<String> findSkills(String resumeText) {

        List<String> skills = new ArrayList<>();

        String text = resumeText.toLowerCase();

        String[] skillList = {
                "java",
                "javascript",
                "python",
                "html",
                "css",
                "sql",
                "react",
                "spring boot",
                "git",
                "github",
                "mongodb",
                "mysql"
        };

        for (String skill : skillList) {

            if (text.contains(skill.toLowerCase())) {
                skills.add(skill);
            }
        }

        return skills;
    }
}