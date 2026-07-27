package com.jobportal.controller;

import com.jobportal.entity.Job;
import com.jobportal.repository.JobRepository;
import com.jobportal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private JobRepository jobRepository;

    // Create Job
    @PostMapping
    public Job createJob(@RequestBody Job job) {
        return jobService.createJob(job);
    }

    // Get All Jobs
    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    // Get Job By ID
    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id) {
        return jobService.getJobById(id);
    }

    // Update Job
    @PutMapping("/{id}")
    public Job updateJob(
            @PathVariable Long id,
            @RequestBody Job updatedJob) {

        return jobService.updateJob(id, updatedJob);
    }

    // Delete Job
    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable Long id) {
        return jobService.deleteJob(id);
    }

    // Search Jobs By Company
    @GetMapping("/search/company/{company}")
    public List<Job> searchByCompany(
            @PathVariable String company) {

        return jobRepository.findByCompany(company);
    }

    // Search Jobs By Title
    @GetMapping("/search/title/{title}")
    public List<Job> searchByTitle(
            @PathVariable String title) {

        return jobRepository.findByTitle(title);
    }

    // Get Jobs With Pagination
    @GetMapping("/page")
    public Page<Job> getJobsWithPagination(
            @RequestParam int page,
            @RequestParam int size) {

        return jobService.getJobsWithPagination(page, size);
    }
}