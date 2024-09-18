package com.hamdihawari.server.project.projectCard;

import com.hamdihawari.server.language.Language;
import com.hamdihawari.server.language.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/project_card")
@CrossOrigin(origins = "http://localhost:5173")
public class ProjectCardController {

    private final ProjectCardService projectCardService;
    private final LanguageService languageService;

    @Autowired
    public ProjectCardController(ProjectCardService projectCardService, LanguageService languageService) {
        this.projectCardService = projectCardService;
        this.languageService = languageService;
    }

    @Autowired
    private ProjectCardRepository projectCardRepository;

    /*@GetMapping
    public List<ProjectCard> getProjects(@RequestParam(value = "language_id", required = false) Long languageId) {
        if (languageId != null) {
            Language language = languageService.getLanguageById(languageId);  // Fetch the Language entity by ID
            return projectCardRepository.findByLanguage(language);
        } else {
            return projectCardService.getAllProjectCards();
        }
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<ProjectCard> getProjectCardById(@PathVariable Long id) {
        Optional<ProjectCard> projectCard = projectCardService.getProjectCardById(id);
        return projectCard.map(card -> new ResponseEntity<>(card, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<ProjectCard>> getProjects(@RequestParam(value = "language_id", required = false) Long languageId) {
        if (languageId != null) {
            Language language = languageService.getLanguageById(languageId);
            if (language == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);  // Return Bad Request if the language doesn't exist
            }
            List<ProjectCard> projectCards = projectCardRepository.findByLanguage(language);
            return new ResponseEntity<>(projectCards, HttpStatus.OK);
        } else {
            List<ProjectCard> allProjectCards = projectCardService.getAllProjectCards();
            return new ResponseEntity<>(allProjectCards, HttpStatus.OK);
        }
    }


    @PostMapping
    public ResponseEntity<ProjectCard> createProjectCard(@RequestBody ProjectCard projectCard) {
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



/*
package com.hamdihawari.server.project.projectCard;

import com.hamdihawari.server.language.Language;
import com.hamdihawari.server.language.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/project_card")
@CrossOrigin(origins = "http://localhost:5173")
public class ProjectCardController {

    private final ProjectCardService projectCardService;
    private final LanguageService languageService;

    @Autowired
    public ProjectCardController(ProjectCardService projectCardService, LanguageService languageService) {
        this.projectCardService = projectCardService;
        this.languageService = languageService;
    }

    @Autowired
    private ProjectCardRepository projectCardRepository;

    @GetMapping
    public List<ProjectCard> getProjects(@RequestParam("language_id") Long languageId) {
        Language language = languageService.getLanguageById(languageId);  // Fetch the Language entity by ID
        return projectCardRepository.findByLanguage(language);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProjectCard>> getAllProjectCards() {
        List<ProjectCard> projectCards = projectCardService.getAllProjectCards();
        return ResponseEntity.ok(projectCards);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectCard> getProjectCardById(@PathVariable Long id) {
        Optional<ProjectCard> projectCard = projectCardService.getProjectCardById(id);
        return projectCard.map(card -> new ResponseEntity<>(card, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ProjectCard> createProjectCard(@RequestBody ProjectCard projectCard) {
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

*/
