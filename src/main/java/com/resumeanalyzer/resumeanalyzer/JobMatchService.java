package com.resumeanalyzer.resumeanalyzer;

import java.util.ArrayList;
import java.util.List;

public class JobMatchService {

    public static int calculateMatchScore(
            String jobRole,
            List<String> resumeSkills) {

        List<String> requiredSkills =
                JobRoleService.getRequiredSkills(jobRole);

        if (requiredSkills.isEmpty()) {
            return 0;
        }

        if (resumeSkills == null) {
            return 0;
        }

        int matchedSkills = 0;

        for (String requiredSkill : requiredSkills) {

            if (resumeSkills.contains(requiredSkill)) {
                matchedSkills++;
            }
        }

        return (matchedSkills * 100)
                / requiredSkills.size();
    }

    public static List<String> findMissingJobSkills(
            String jobRole,
            List<String> resumeSkills) {

        List<String> requiredSkills =
                JobRoleService.getRequiredSkills(jobRole);

        List<String> missingSkills =
                new ArrayList<>();

        if (resumeSkills == null) {
            missingSkills.addAll(requiredSkills);
            return missingSkills;
        }

        for (String requiredSkill : requiredSkills) {

            if (!resumeSkills.contains(requiredSkill)) {
                missingSkills.add(requiredSkill);
            }
        }

        return missingSkills;
    }
}
