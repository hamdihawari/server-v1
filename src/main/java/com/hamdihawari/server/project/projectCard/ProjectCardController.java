
package com.hamdihawari.server.project.projectCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/project-card")
@CrossOrigin(origins = "http://localhost:5173")
public class ProjectCardController {

    private final ProjectCardService projectCardService;

    @Autowired
    public ProjectCardController(ProjectCardService projectCardService) {
        this.projectCardService = projectCardService;
    }

    @GetMapping
    public ResponseEntity<List<ProjectCard>> getAllProjectCards() {
        return new ResponseEntity<>(projectCardService.getAllProjectCards(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectCard> getProjectCardById(@PathVariable Long id) {
        Optional<ProjectCard> projectCard = projectCardService.getProjectCardById(id);
        return projectCard.map(card -> new ResponseEntity<>(card, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ProjectCard> createProjectCard(@RequestBody ProjectCard projectCard) {
        System.out.println("Received ProjectCard: " + projectCard);
        return new ResponseEntity<>(projectCardService.createOrUpdateProjectCard(projectCard), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProjectCard> updateProjectCard(@PathVariable Long id, @RequestBody ProjectCard projectCard) {
        Optional<ProjectCard> existingCard = projectCardService.getProjectCardById(id);
        if (existingCard.isPresent()) {
            projectCard.setId(id);
            return new ResponseEntity<>(projectCardService.createOrUpdateProjectCard(projectCard), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjectCard(@PathVariable Long id) {
        Optional<ProjectCard> existingCard = projectCardService.getProjectCardById(id);
        if (existingCard.isPresent()) {
            projectCardService.deleteProjectCard(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

