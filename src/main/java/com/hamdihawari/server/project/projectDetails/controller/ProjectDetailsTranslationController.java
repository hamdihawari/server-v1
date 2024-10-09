package com.hamdihawari.server.project.projectDetails.controller;

import com.hamdihawari.server.project.language.entity.Language;
import com.hamdihawari.server.project.language.repository.LanguageRepository;
import com.hamdihawari.server.project.projectDetails.dto.ProjectDetailsTranslationDTO;
import com.hamdihawari.server.project.projectDetails.entity.ProjectDetails;
import com.hamdihawari.server.project.projectDetails.entity.ProjectDetailsTranslation;
import com.hamdihawari.server.project.projectDetails.service.ProjectDetailsTranslationService;
import com.hamdihawari.server.project.projectDetails.service.ProjectDetailsService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project_details_translation")
public class ProjectDetailsTranslationController {

    private final ProjectDetailsTranslationService projectDetailsTranslationService;
    private final ProjectDetailsService projectDetailsService;
    private final LanguageRepository languageRepository;

    @Autowired
    public ProjectDetailsTranslationController(
            ProjectDetailsTranslationService projectDetailsTranslationService,
            ProjectDetailsService projectDetailsService,
            LanguageRepository languageRepository) {
        this.projectDetailsTranslationService = projectDetailsTranslationService;
        this.projectDetailsService = projectDetailsService;
        this.languageRepository = languageRepository;
    }

    @GetMapping
    public ResponseEntity<List<ProjectDetailsTranslation>> getAllProjectDetailsTranslations() {
        List<ProjectDetailsTranslation> translations = projectDetailsTranslationService.getAllTranslations();
        return ResponseEntity.ok(translations);
    }

    // New method to get translation by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProjectDetailsTranslation> getTranslationById(@PathVariable Long id) {
        ProjectDetailsTranslation translation = projectDetailsTranslationService.getTranslationById(id);
        return ResponseEntity.ok().body(translation);
    }

    @PostMapping
    public ResponseEntity<ProjectDetailsTranslation> createTranslation(@RequestBody ProjectDetailsTranslationDTO translationDTO) {
        ProjectDetails projectDetails = projectDetailsService.findById(translationDTO.getProjectDetailsId())
                .orElseThrow(() -> new EntityNotFoundException("Project Details not found"));

        Language language = languageRepository.findById(translationDTO.getLanguageId())
                .orElseThrow(() -> new EntityNotFoundException("Language not found"));

        // Create the new translation
        ProjectDetailsTranslation translation = new ProjectDetailsTranslation();
        translation.setProjectDetails(projectDetails);
        translation.setLanguage(language);
        translation.setSubjectDetails(translationDTO.getSubjectDetails());
        translation.setCardDescription(translationDTO.getCardDescription());

        ProjectDetailsTranslation savedTranslation = projectDetailsTranslationService.saveTranslation(translation);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTranslation);
    }

    @GetMapping("/project/{projectDetailsId}")
    public ResponseEntity<List<ProjectDetailsTranslation>> getTranslationsByProjectDetailsId(@PathVariable Long projectDetailsId) {
        List<ProjectDetailsTranslation> translations = projectDetailsTranslationService.getTranslationsByProjectDetailsId(projectDetailsId);
        return ResponseEntity.ok(translations);
    }

    @GetMapping("/project/{projectDetailsId}/language/{languageCode}")
    public ResponseEntity<ProjectDetailsTranslation> getProjectDetailsTranslationByLanguage(
            @PathVariable Long projectDetailsId, @PathVariable String languageCode) {
        ProjectDetailsTranslation translation = projectDetailsTranslationService
                .getTranslationByProjectDetailsAndLanguage(projectDetailsId, languageCode);
        return ResponseEntity.ok().body(translation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDetailsTranslation> updateTranslation(
            @PathVariable Long id, @RequestBody ProjectDetailsTranslation translation) {
        ProjectDetailsTranslation updatedTranslation = projectDetailsTranslationService.updateTranslation(id, translation);
        return updatedTranslation != null ? ResponseEntity.ok(updatedTranslation) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTranslation(@PathVariable Long id) {
        projectDetailsTranslationService.deleteTranslation(id);
        return ResponseEntity.noContent().build();
    }
}