package com.hamdihawari.server.projectCard.controller;

import com.hamdihawari.server.projectCard.dto.ProjectCardDTO;
import com.hamdihawari.server.projectCard.entity.ProjectCard;
import com.hamdihawari.server.projectCard.service.ProjectCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/project_card")
public class ProjectCardController {

    // Constructor injection of the service
    public ProjectCardController(ProjectCardService projectCardService) {
        this.projectCardService = projectCardService;
    }

    @Autowired
    private ProjectCardService projectCardService;

    @GetMapping
    public List<ProjectCard> getAllProjectCards() {
        // Assuming you have a service method to fetch the project cards
        return projectCardService.getAllProjectCards();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectCardDTO> getProjectCardById(@PathVariable Long id) {
        ProjectCard projectCard = projectCardService.getProjectCardById(id);
        return projectCard != null ? ResponseEntity.ok(convertToDTO(projectCard)) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ProjectCardDTO createProjectCard(@RequestBody ProjectCardDTO projectCardDTO) {
        ProjectCard projectCard = convertToEntity(projectCardDTO);
        projectCard = projectCardService.saveProjectCard(projectCard);
        return convertToDTO(projectCard);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjectCard(@PathVariable Long id) {
        projectCardService.deleteProjectCard(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectCardDTO> updateProjectCard(@PathVariable Long id, @RequestBody ProjectCardDTO projectCardDTO) {
        ProjectCard existingProjectCard = projectCardService.getProjectCardById(id);

        if (existingProjectCard == null) {
            return ResponseEntity.notFound().build();
        }

        // Update the fields
        existingProjectCard.setImage(projectCardDTO.getImage());
        existingProjectCard.setImageHover(projectCardDTO.getImageHover());

        // Save the updated entity
        ProjectCard updatedProjectCard = projectCardService.saveProjectCard(existingProjectCard);

        return ResponseEntity.ok(convertToDTO(updatedProjectCard));
    }


    // Hilfsmethoden zum Konvertieren zwischen DTO und Entity
    private ProjectCardDTO convertToDTO(ProjectCard projectCard) {
        ProjectCardDTO dto = new ProjectCardDTO();
        dto.setId(projectCard.getId());
        dto.setPath(projectCard.getPath());
        dto.setIcon(projectCard.getIcon());
        dto.setImage(projectCard.getImage());
        dto.setImageHover(projectCard.getImageHover());
        return dto;
    }

    private ProjectCard convertToEntity(ProjectCardDTO dto) {
        ProjectCard projectCard = new ProjectCard();
        projectCard.setId(dto.getId());
        projectCard.setPath(dto.getPath());
        projectCard.setIcon(dto.getIcon());
        projectCard.setImage(dto.getImage());
        projectCard.setImageHover(dto.getImageHover());
        return projectCard;
    }

}