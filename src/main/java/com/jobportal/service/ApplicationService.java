package com.jobportal.service;

import com.jobportal.entity.Application;
import com.jobportal.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    // Apply for Job
    public Application applyForJob(Application application) {

        application.setStatus("APPLIED");

        return applicationRepository.save(application);
    }

    // Update Application Status
    public Application updateStatus(Long applicationId,
                                    String status) {

        Application application =
                applicationRepository.findById(applicationId)
                        .orElseThrow(() ->
                                new RuntimeException("Application not found"));

        application.setStatus(status);

        return applicationRepository.save(application);
    }
}