package com.resumeanalyzer.resumeanalyzer.controller;

import com.resumeanalyzer.resumeanalyzer.JobRecommendationService;
import com.resumeanalyzer.resumeanalyzer.JobMatchService;
import com.resumeanalyzer.resumeanalyzer.ResumeAnalyzer;
import com.resumeanalyzer.resumeanalyzer.ResumeQualityService;
import com.resumeanalyzer.resumeanalyzer.ResumeScoreService;
import com.resumeanalyzer.resumeanalyzer.ResumeTextExtractor;
import com.resumeanalyzer.resumeanalyzer.repository.ResumeRepository;
import com.resumeanalyzer.resumeanalyzer.repository.entity.Resume;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    private final ResumeRepository resumeRepository;

    public ResumeController(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    @PostMapping("/upload")
    public ResponseEntity<Map<String, Object>> uploadResume(
            @RequestParam("file") MultipartFile file,
            @RequestParam("jobRole") String jobRole) {

        Map<String, Object> response = new HashMap<>();

        if (file == null || file.isEmpty()) {
            response.put(
                    "message",
                    "Please select a valid file to upload"
            );

            return ResponseEntity
                    .badRequest()
                    .body(response);
        }

        try {

            String uploadDir =
                    System.getProperty("user.dir")
                            + File.separator
                            + "uploads";

            File directory =
                    new File(uploadDir);

            if (!directory.exists()) {
                directory.mkdirs();
            }

            String fileName =
                    file.getOriginalFilename();

            if (fileName == null ||
                    fileName.trim().isEmpty()) {

                response.put(
                        "message",
                        "Invalid file name"
                );

                return ResponseEntity
                        .badRequest()
                        .body(response);
            }

            File savedFile =
                    new File(
                            directory.getAbsolutePath()
                                    + File.separator
                                    + fileName
                    );

            file.transferTo(savedFile);

            String resumeText =
                    ResumeTextExtractor.extractText(
                            savedFile.getAbsolutePath()
                    );

            /*
             * Step 1: Basic PDF text validation
             */
            if (resumeText == null ||
                    resumeText.trim().length() < 30) {

                response.put(
                        "message",
                        "The uploaded PDF appears to be empty or contains no readable resume text. Please upload a valid resume PDF."
                );

                return ResponseEntity
                        .badRequest()
                        .body(response);
            }


            if (!isValidResumeContent(resumeText)) {

                response.put(
                        "message",
                        "The uploaded PDF does not appear to contain sufficient resume information. Please upload a complete resume with actual details such as skills, education, projects, experience or contact information."
                );

                return ResponseEntity
                        .badRequest()
                        .body(response);
            }

            List<String> skills =
                    ResumeAnalyzer.findSkills(
                            resumeText
                    );

            List<String> recommendedJobs =
                    JobRecommendationService.recommendJobs(
                            skills
                    );

            int atsScore =
                    ResumeScoreService.calculateScore(
                            skills,
                            resumeText
                    );

            Map<String, Integer> scoreBreakdown =
                    ResumeScoreService.calculateBreakdown(
                            skills,
                            resumeText
                    );

            List<String> missingSkills =
                    ResumeScoreService.findRoleBasedMissingSkills(
                            jobRole,
                            skills
                    );

            List<String> strengths =
                    ResumeQualityService.findStrengths(
                            jobRole,
                            skills
                    );

            List<String> suggestions =
                    ResumeQualityService.findSuggestions(
                            jobRole,
                            skills
                    );

            Resume resume =
                    new Resume();

            resume.setFileName(fileName);

            resume.setAtsScore(atsScore);

            resume.setSkills(
                    skills != null
                            ? String.join(", ", skills)
                            : ""
            );

            resume.setRecommendedJobs(
                    recommendedJobs != null
                            ? String.join(
                            ", ",
                            recommendedJobs
                    )
                            : ""
            );

            resume.setMissingSkills(
                    missingSkills != null
                            ? String.join(
                            ", ",
                            missingSkills
                    )
                            : ""
            );

            resume.setStrengths(
                    strengths != null
                            ? String.join(
                            ", ",
                            strengths
                    )
                            : ""
            );

            resume.setSuggestions(
                    suggestions != null
                            ? String.join(
                            ", ",
                            suggestions
                    )
                            : ""
            );

            Resume savedResume =
                    resumeRepository.save(resume);

            response.put(
                    "message",
                    "Resume analyzed and saved successfully"
            );

            response.put(
                    "id",
                    savedResume.getId()
            );

            response.put(
                    "fileName",
                    fileName
            );

            response.put(
                    "skills",
                    skills
            );

            response.put(
                    "recommendedJobs",
                    recommendedJobs
            );

            response.put(
                    "atsScore",
                    atsScore
            );

            response.put(
                    "scoreBreakdown",
                    scoreBreakdown
            );

            response.put(
                    "missingSkills",
                    missingSkills
            );

            response.put(
                    "strengths",
                    strengths
            );

            response.put(
                    "suggestions",
                    suggestions
            );

            return ResponseEntity
                    .ok(response);

        } catch (java.io.IOException e) {

            e.printStackTrace();

            response.put(
                    "message",
                    "Invalid or corrupted PDF. Please upload a valid PDF resume."
            );

            response.put(
                    "error",
                    "The uploaded PDF could not be read."
            );

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(response);

        } catch (Exception e) {

            e.printStackTrace();

            response.put(
                    "message",
                    "Resume analysis failed. Please try again."
            );

            response.put(
                    "error",
                    e.getMessage() != null
                            ? e.getMessage()
                            : e.toString()
            );

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(response);
        }

    }


    private boolean isValidResumeContent(String resumeText) {

        if (resumeText == null ||
                resumeText.trim().isEmpty()) {

            return false;
        }

        String text =
                resumeText.toLowerCase().trim();

        boolean hasContact =
                text.contains("@")
                        || text.matches("(?s).*\\d{10}.*");

        boolean hasTechnicalSkill =
                text.contains("java")
                        || text.contains("javascript")
                        || text.contains("python")
                        || text.contains("html")
                        || text.contains("css")
                        || text.contains("sql")
                        || text.contains("react")
                        || text.contains("spring boot")
                        || text.contains("git")
                        || text.contains("github")
                        || text.contains("mongodb")
                        || text.contains("mysql");

        boolean hasEducation =
                text.contains("education")
                        || text.contains("mca")
                        || text.contains("bsc")
                        || text.contains("b.sc")
                        || text.contains("bachelor")
                        || text.contains("master");

        boolean hasProject =
                text.contains("project")
                        || text.contains("projects");

        boolean hasExperience =
                text.contains("experience")
                        || text.contains("work experience");


        boolean validWithContact =
                hasContact
                        && (hasTechnicalSkill
                        || hasEducation
                        || hasProject
                        || hasExperience);

        boolean validWithTechnicalDetails =
                hasTechnicalSkill
                        && (hasEducation
                        || hasProject
                        || hasExperience);

        return validWithContact
                || validWithTechnicalDetails;
    }

    @GetMapping("/all")
    public List<Resume> getAllResumes() {

        return resumeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getResumeById(
            @PathVariable Long id) {

        Map<String, Object> response =
                new HashMap<>();

        return resumeRepository.findById(id)
                .map(resume -> {

                    response.put(
                            "id",
                            resume.getId()
                    );

                    response.put(
                            "fileName",
                            resume.getFileName()
                    );

                    response.put(
                            "atsScore",
                            resume.getAtsScore()
                    );

                    response.put(
                            "selectedJobRole",
                            resume.getSelectedJobRole()
                    );

                    response.put(
                            "jobMatchScore",
                            resume.getJobMatchScore()
                    );
                    String selectedJobRole =
                            resume.getSelectedJobRole();

                    List<String> resumeSkills =
                            resume.getSkills() != null
                                    ? List.of(
                                    resume.getSkills()
                                            .split(",\\s*")
                            )
                                    : List.of();

                    List<String> missingJobSkills =
                            JobMatchService.findMissingJobSkills(
                                    selectedJobRole,
                                    resumeSkills
                            );

                    response.put(
                            "missingJobSkills",
                            missingJobSkills
                    );

                    response.put(
                            "skills",
                            resume.getSkills()
                    );

                    response.put(
                            "recommendedJobs",
                            resume.getRecommendedJobs()
                    );

                    response.put(
                            "missingSkills",
                            resume.getMissingSkills()
                    );

                    response.put(
                            "strengths",
                            resume.getStrengths()
                    );

                    response.put(
                            "suggestions",
                            resume.getSuggestions()
                    );

                    return ResponseEntity
                            .ok(response);
                })
                .orElseGet(() -> {

                    response.put(
                            "message",
                            "Resume not found"
                    );

                    response.put(
                            "id",
                            id
                    );

                    return ResponseEntity
                            .status(
                                    HttpStatus.NOT_FOUND
                            )
                            .body(response);
                });
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteResume(
            @PathVariable Long id) {

        Map<String, Object> response =
                new HashMap<>();

        if (resumeRepository.existsById(id)) {

            resumeRepository.deleteById(id);

            response.put(
                    "message",
                    "Resume deleted successfully"
            );

            response.put(
                    "id",
                    id
            );

            return ResponseEntity
                    .ok(response);

        } else {

            response.put(
                    "message",
                    "Resume not found"
            );

            response.put(
                    "id",
                    id
            );

            return ResponseEntity
                    .status(
                            HttpStatus.NOT_FOUND
                    )
                    .body(response);
        }
    }
}