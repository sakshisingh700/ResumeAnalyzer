package com.resumeanalyzer.resumeanalyzer.controller;

import com.resumeanalyzer.resumeanalyzer.JobRoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/job")
public class JobRoleController {

    @GetMapping("/roles")
    public List<String> getJobRoles() {
        return JobRoleService.getJobRoles();
    }
}