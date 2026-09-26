package com.resumeanalyzer.resumeanalyzer.controller;

import com.resumeanalyzer.resumeanalyzer.JobMatchService;
import com.resumeanalyzer.resumeanalyzer.repository.ResumeRepository;
import com.resumeanalyzer.resumeanalyzer.repository.entity.Resume;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/job")
public class JobMatchController {

    private final ResumeRepository resumeRepository;

    public JobMatchController(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    @GetMapping("/match")
    public Map<String, Object> getJobMatch(
            @RequestParam String role,
            @RequestParam String skills,
            @RequestParam Long resumeId) {

        List<String> resumeSkills =
                List.of(skills.toLowerCase().split(","));

        int matchScore =
                JobMatchService.calculateMatchScore(
                        role,
                        resumeSkills
                );

        List<String> missingSkills =
                JobMatchService.findMissingJobSkills(
                        role,
                        resumeSkills
                );

        Resume resume =
                resumeRepository.findById(resumeId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Resume not found with ID: " + resumeId
                                )
                        );

        resume.setSelectedJobRole(role);
        resume.setJobMatchScore(matchScore);

        resumeRepository.save(resume);

        Map<String, Object> response =
                new HashMap<>();

        response.put("jobRole", role);
        response.put("matchScore", matchScore);
        response.put("missingSkills", missingSkills);
        response.put("resumeId", resumeId);

        return response;
    }
}