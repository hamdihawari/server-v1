
package com.hamdihawari.server.project.projectCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectCardService {

    private final ProjectCardRepository projectCardRepository;

    @Autowired
    public ProjectCardService(ProjectCardRepository projectCardRepository) {
        this.projectCardRepository = projectCardRepository;
    }

    public List<ProjectCard> getAllProjectCards() {
        return projectCardRepository.findAll();
    }

    public Optional<ProjectCard> getProjectCardById(Long id) {
        return projectCardRepository.findById(id);
    }

    public ProjectCard createOrUpdateProjectCard(ProjectCard projectCard) {
        return projectCardRepository.save(projectCard);
    }

    public void deleteProjectCard(Long id) {
        projectCardRepository.deleteById(id);
    }
}
