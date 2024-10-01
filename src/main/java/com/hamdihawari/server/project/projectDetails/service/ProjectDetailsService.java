package com.hamdihawari.server.project.projectDetails.service;

import com.hamdihawari.server.project.projectDetails.entity.ProjectDetails;
import com.hamdihawari.server.project.projectDetails.repository.ProjectDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectDetailsService {

    @Autowired
    private ProjectDetailsRepository projectDetailsRepository;

    public ProjectDetails getProjectDetailsByProjectCardId(Long projectCardId) {
        return projectDetailsRepository.findByProjectCardId(projectCardId);
    }

    public ProjectDetails saveProjectDetails(ProjectDetails projectDetails) {
        return projectDetailsRepository.save(projectDetails);
    }

    public void deleteProjectDetails(Long id) {
        projectDetailsRepository.deleteById(id);
    }

    // New method to retrieve all project details
    public List<ProjectDetails> getAllProjectDetails() {
        return projectDetailsRepository.findAll();
    }

    public ProjectDetails updateProjectDetails(Long id, ProjectDetails projectDetails) {
        // Check if the project details exist
        if (projectDetailsRepository.existsById(id)) {
            // Set the ID of the existing project details to ensure it updates correctly
            projectDetails.setId(id);
            return projectDetailsRepository.save(projectDetails);
        } else {
            return null; // or throw an exception if you prefer
        }
    }

}
