package com.hamdihawari.server.project.projectDetails.service;

import com.hamdihawari.server.project.language.repository.LanguageRepository;
import com.hamdihawari.server.project.projectDetails.entity.ProjectDetails;
import com.hamdihawari.server.project.projectDetails.entity.ProjectDetailsTranslation;
import com.hamdihawari.server.project.projectDetails.repository.ProjectDetailsRepository;
import com.hamdihawari.server.project.projectDetails.repository.ProjectDetailsTranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectDetailsTranslationService {

    private final ProjectDetailsTranslationRepository projectDetailsTranslationRepository;
    private final LanguageRepository languageRepository;
    private final ProjectDetailsRepository projectDetailsRepository;

    @Autowired
    public ProjectDetailsTranslationService(
            ProjectDetailsTranslationRepository projectDetailsTranslationRepository,
            LanguageRepository languageRepository,
            ProjectDetailsRepository projectDetailsRepository) {
        this.projectDetailsTranslationRepository = projectDetailsTranslationRepository;
        this.languageRepository = languageRepository;
        this.projectDetailsRepository = projectDetailsRepository;
    }

    public List<ProjectDetailsTranslation> getAllTranslations() {
        return projectDetailsTranslationRepository.findAll();
    }

    public List<ProjectDetailsTranslation> getTranslationsByProjectDetailsId(Long projectDetailsId) {
        return projectDetailsTranslationRepository.findByProjectDetailsId(projectDetailsId);
    }

    public ProjectDetailsTranslation getTranslationById(Long id) {
        return projectDetailsTranslationRepository.findById(id).orElse(null); // Return null if not found
    }

    @Transactional
    public ProjectDetailsTranslation saveTranslation(ProjectDetailsTranslation translation) {
        return projectDetailsTranslationRepository.save(translation);
    }

    public ProjectDetailsTranslation getTranslationByProjectDetailsAndLanguage(Long projectDetailsId, String languageCode) {
        return projectDetailsTranslationRepository.findByProjectDetailsIdAndLanguageName(projectDetailsId, languageCode);
    }

    public void deleteTranslation(Long id) {
        projectDetailsTranslationRepository.deleteById(id);
    }

    @Transactional
    public ProjectDetailsTranslation updateTranslation(Long id, ProjectDetailsTranslation translation) {
        if (projectDetailsTranslationRepository.existsById(id)) {
            translation.setId(id); // Ensure the ID is set for the update
            return projectDetailsTranslationRepository.save(translation);
        }
        return null; // Return null if the translation with the given ID doesn't exist
    }

    public Optional<ProjectDetails> findById(Long id) {
        return projectDetailsRepository.findById(id);
    }
}
