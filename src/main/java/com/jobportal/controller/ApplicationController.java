package com.jobportal.controller;

import com.jobportal.entity.Application;
import com.jobportal.repository.ApplicationRepository;
import com.jobportal.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private ApplicationRepository applicationRepository;

    // Apply for Job
    @PostMapping
    public Application applyForJob(
            @RequestBody Application application) {

        return applicationService.applyForJob(application);
    }

    // Get All Applications
    @GetMapping
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    // Get Applications By User ID
    @GetMapping("/user/{userId}")
    public List<Application> getApplicationsByUserId(
            @PathVariable Long userId) {

        return applicationRepository.findByUserId(userId);
    }

    // Get Applications By Job ID
    @GetMapping("/job/{jobId}")
    public List<Application> getApplicationsByJobId(
            @PathVariable Long jobId) {

        return applicationRepository.findByJobId(jobId);
    }

    // Update Application Status
    @PutMapping("/{id}/status")
    public Application updateApplicationStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return applicationService.updateStatus(id, status);
    }
}