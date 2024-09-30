package com.hamdihawari.server.projectCard.controller;

import com.hamdihawari.server.projectCard.dto.ProjectCardTranslationDTO;
import com.hamdihawari.server.projectCard.entity.ProjectCardTranslation;
import com.hamdihawari.server.projectCard.service.ProjectCardTranslationService;
import com.hamdihawari.server.projectCard.service.ProjectCardService;
import com.hamdihawari.server.language.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectCardTranslationController {

    @Autowired
    private ProjectCardTranslationService projectCardTranslationService;

    @Autowired
    private ProjectCardService projectCardService;

    @Autowired
    private LanguageService languageService;

    // Mapping for creating a translation
    @PostMapping("/project_card_translation/create")
    public ResponseEntity<ProjectCardTranslation> createTranslation(@RequestBody ProjectCardTranslationDTO translationDTO) {
        ProjectCardTranslation translation = new ProjectCardTranslation();

        translation.setProjectCard(projectCardService.findById(translationDTO.getProjectCardId()));
        translation.setLanguage(languageService.findById(translationDTO.getLanguageId()));
        translation.setSubject(translationDTO.getSubject());
        translation.setData(translationDTO.getData());
        translation.setDescription(translationDTO.getDescription());

        ProjectCardTranslation savedTranslation = projectCardTranslationService.save(translation);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTranslation);
    }

    // Mapping for creating a project card translation with a different endpoint
    @PostMapping("/project_card_translation/custom_create")
    public ResponseEntity<?> createProjectCardTranslation(@RequestBody ProjectCardTranslationDTO dto) {
        try {
            ProjectCardTranslation translation = projectCardTranslationService.createProjectCardTranslation(dto);
            return new ResponseEntity<>(translation, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Mapping for fetching all project card translations
    @GetMapping("/project_card_translation")
    public ResponseEntity<List<ProjectCardTranslation>> getAllTranslations() {
        List<ProjectCardTranslation> translations = projectCardTranslationService.findAll();
        return ResponseEntity.ok(translations);
    }

    // Mapping for fetching a project card translation by ID
    @GetMapping("/project_card_translation/{id}")
    public ResponseEntity<ProjectCardTranslation> getTranslationById(@PathVariable Long id) {
        ProjectCardTranslation translation = projectCardTranslationService.findById(id);
        if (translation != null) {
            return ResponseEntity.ok(translation);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Mapping for updating a project card translation (PUT method)
    @PutMapping("/project_card_translation/{id}")
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

        // Save the updated translation
        ProjectCardTranslation updatedTranslation = projectCardTranslationService.save(existingTranslation);
        return ResponseEntity.ok(updatedTranslation);
    }

    @DeleteMapping("/project_card_translation/{id}")
    public ResponseEntity<Void> deleteTranslation(@PathVariable Long id) {
        try {
            projectCardTranslationService.deleteTranslation(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return 204 No Content on success
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if the entity was not found
        }
    }
}