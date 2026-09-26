package com.resumeanalyzer.resumeanalyzer;

import java.util.*;

public class JobRoleService {

    private static final Map<String, List<String>> JOB_SKILLS =
            new LinkedHashMap<>();

    static {
        JOB_SKILLS.put(
                "Java Developer",
                Arrays.asList(
                        "java",
                        "sql",
                        "spring boot",
                        "git",
                        "github"
                )
        );

        JOB_SKILLS.put(
                "Frontend Developer",
                Arrays.asList(
                        "html",
                        "css",
                        "javascript",
                        "react",
                        "git",
                        "github"
                )
        );

        JOB_SKILLS.put(
                "Software Developer",
                Arrays.asList(
                        "java",
                        "javascript",
                        "sql",
                        "git",
                        "github",
                        "react"
                )
        );


        JOB_SKILLS.put(
                "Full Stack Developer",
                Arrays.asList(
                        "java",
                        "javascript",
                        "html",
                        "css",
                        "react",
                        "sql",
                        "spring boot",
                        "git"
                )
        );

        JOB_SKILLS.put(
                "Data Analyst",
                Arrays.asList(
                        "python",
                        "sql",
                        "excel",
                        "power bi",
                        "statistics"
                )
        );

    }

    public static List<String> getJobRoles() {
        return new ArrayList<>(JOB_SKILLS.keySet());
    }

    public static List<String> getRequiredSkills(
            String jobRole) {

        return JOB_SKILLS.getOrDefault(
                jobRole,
                new ArrayList<>()
        );
    }
}