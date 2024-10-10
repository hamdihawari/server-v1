
package com.hamdihawari.server.project.projectCard.controller;

import com.hamdihawari.server.project.projectCard.dto.ProjectCardTranslationDTO;
import com.hamdihawari.server.project.projectCard.entity.ProjectCardTranslation;
import com.hamdihawari.server.project.projectCard.service.ProjectCardTranslationService;
import com.hamdihawari.server.project.projectCard.service.ProjectCardService;
import com.hamdihawari.server.project.language.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project_card_translation")
public class ProjectCardTranslationController {

    private final ProjectCardTranslationService projectCardTranslationService;
    private final ProjectCardService projectCardService;
    private final LanguageService languageService;

    @Autowired
    public ProjectCardTranslationController(ProjectCardTranslationService projectCardTranslationService,
                                            ProjectCardService projectCardService,
                                            LanguageService languageService) {
        this.projectCardTranslationService = projectCardTranslationService;
        this.projectCardService = projectCardService;
        this.languageService = languageService;
    }

    // http://localhost:8080/project_card_translation/project/1/language/en
    @GetMapping("/project/{id}/language/{code}")
    public ResponseEntity<ProjectCardTranslation> getProjectTranslationByIdAndLanguage(@PathVariable Long id, @PathVariable String code) {
        ProjectCardTranslation translation = projectCardTranslationService.findTranslationByIdAndLanguageCode(id, code);
        if (translation != null) {
            return ResponseEntity.ok(translation);
        } else {
            System.out.println("Translation not found for projectCardId: " + id + " and languageCode: " + code);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // No body returned for not found
        }
    }

    // http://localhost:8080/project_card_translation/project/1/language/id/1
    // New endpoint to get translation by language ID
    @GetMapping("/project/{id}/language/id/{languageId}")
    public ResponseEntity<ProjectCardTranslation> getProjectTranslationByIdAndLanguageId(@PathVariable Long id, @PathVariable Long languageId) {
        ProjectCardTranslation translation = projectCardTranslationService.findTranslationByIdAndLanguageId(id, languageId);
        if (translation != null) {
            return ResponseEntity.ok(translation);
        } else {
            System.out.println("Translation not found for projectCardId: " + id + " and languageId: " + languageId);
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ProjectCardTranslation> createTranslation(@RequestBody ProjectCardTranslationDTO translationDTO) {
        ProjectCardTranslation translation = projectCardTranslationService.createProjectCardTranslation(translationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(translation);
    }

    @GetMapping
    public ResponseEntity<List<ProjectCardTranslation>> getAllTranslations() {
        List<ProjectCardTranslation> translations = projectCardTranslationService.findAll();
        return ResponseEntity.ok(translations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectCardTranslation> getTranslationById(@PathVariable Long id) {
        ProjectCardTranslation translation = projectCardTranslationService.findById(id);
        return translation != null ? ResponseEntity.ok(translation) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTranslation(@PathVariable Long id, @RequestBody ProjectCardTranslationDTO translationDTO) {
        ProjectCardTranslation existingTranslation = projectCardTranslationService.findById(id);
        if (existingTranslation == null) {
            return new ResponseEntity<>("Translation not found", HttpStatus.NOT_FOUND);
        }

        // Update the translation fields
        existingTranslation.setSubject(translationDTO.getSubject());
        existingTranslation.setData(translationDTO.getData());
        existingTranslation.setDescription(translationDTO.getDescription());

        // Optionally update projectCard and language if provided
        if (translationDTO.getProjectCardId() != null) {
            existingTranslation.setProjectCard(projectCardService.findById(translationDTO.getProjectCardId()));
        }

        if (translationDTO.getLanguageId() != null) {
            existingTranslation.setLanguage(languageService.findById(translationDTO.getLanguageId()));
        }

        ProjectCardTranslation updatedTranslation = projectCardTranslationService.save(existingTranslation);
        return ResponseEntity.ok(updatedTranslation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTranslation(@PathVariable Long id) {
        try {
            projectCardTranslationService.deleteTranslation(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}