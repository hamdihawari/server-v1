package com.hamdihawari.server.project.projectDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectDetailService {

    private final ProjectDetailRepository projectDetailRepository;

    @Autowired
    public ProjectDetailService(ProjectDetailRepository projectDetailRepository) {
        this.projectDetailRepository = projectDetailRepository;
    }

    public List<ProjectDetails> getAllProjectDetails() {
        return projectDetailRepository.findAll();
    }

    public Optional<ProjectDetails> getProjectDetailById(Long id) {
        return projectDetailRepository.findById(id);
    }

    public ProjectDetails createOrUpdateProjectDetail(ProjectDetails projectDetail) {
        return projectDetailRepository.save(projectDetail);
    }

    public void deleteProjectDetail(Long id) {
        projectDetailRepository.deleteById(id);
    }
}
