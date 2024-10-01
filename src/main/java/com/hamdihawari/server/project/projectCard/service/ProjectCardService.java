package com.hamdihawari.server.project.projectCard.service;

import com.hamdihawari.server.project.projectCard.entity.ProjectCard;
import com.hamdihawari.server.project.projectCard.repository.ProjectCardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectCardService {

    @Autowired
    private ProjectCardRepository projectCardRepository;


    public ProjectCardService(ProjectCardRepository projectCardRepository) {
        this.projectCardRepository = projectCardRepository;
    }

    public List<ProjectCard> getAllProjectCards() {
        return projectCardRepository.findAll();
    }

    public ProjectCard getProjectCardById(Long id) {
        return projectCardRepository.findById(id).orElse(null);
    }

    public ProjectCard saveProjectCard(ProjectCard projectCard) {
        return projectCardRepository.save(projectCard);
    }

    public void deleteProjectCard(Long id) {
        projectCardRepository.deleteById(id);
    }

    public ProjectCard findById(Long id) {
        return projectCardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project Card not found with id: " + id));
    }
}