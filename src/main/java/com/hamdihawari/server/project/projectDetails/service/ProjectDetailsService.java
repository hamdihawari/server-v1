package com.hamdihawari.server.project.projectDetails.service;

import com.hamdihawari.server.project.projectDetails.entity.ProjectDetails;
import com.hamdihawari.server.project.projectDetails.repository.ProjectDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectDetailsService {

    private final ProjectDetailsRepository projectDetailsRepository;

    @Autowired
    public ProjectDetailsService(ProjectDetailsRepository projectDetailsRepository) {
        this.projectDetailsRepository = projectDetailsRepository;
    }

    public ProjectDetails getProjectDetailsByProjectCardId(Long projectCardId) {
        return projectDetailsRepository.findByProjectCardId(projectCardId);
    }

    public ProjectDetails saveProjectDetails(ProjectDetails projectDetails) {
        return projectDetailsRepository.save(projectDetails);
    }

    public void deleteProjectDetails(Long id) {
        projectDetailsRepository.deleteById(id);
    }

    public List<ProjectDetails> getAllProjectDetails() {
        return projectDetailsRepository.findAll();
    }

    public Optional<ProjectDetails> findById(Long id) {
        return projectDetailsRepository.findById(id);
    }

    public ProjectDetails updateProjectDetails(Long id, ProjectDetails projectDetails) {
        return projectDetailsRepository.findById(id)
                .map(existingDetails -> {
                    projectDetails.setId(id); // Ensure the ID is set for the update
                    return projectDetailsRepository.save(projectDetails);
                }).orElse(null); // or throw an exception if you prefer
    }
}
