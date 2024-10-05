package com.hamdihawari.server.project.projectDetails.service;

import com.hamdihawari.server.project.language.repository.LanguageRepository;
import com.hamdihawari.server.project.projectDetails.entity.ProjectDetails;
import com.hamdihawari.server.project.projectDetails.entity.ProjectDetailsTranslation;
import com.hamdihawari.server.project.projectDetails.repository.ProjectDetailsRepository;
import com.hamdihawari.server.project.projectDetails.repository.ProjectDetailsTranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;  // Import statement

import java.util.List;
import java.util.Optional;

@Service
public class ProjectDetailsTranslationService {

    @Autowired
    private ProjectDetailsTranslationRepository projectDetailsTranslationRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private ProjectDetailsRepository projectDetailsRepository; // Ensure you have this injected

    public List<ProjectDetailsTranslation> getAllTranslations() {
        return projectDetailsTranslationRepository.findAll();
    }

    public List<ProjectDetailsTranslation> getTranslationsByProjectDetailsId(Long projectDetailsId) {
        return projectDetailsTranslationRepository.findByProjectDetailsId(projectDetailsId);
    }

    @Transactional  // Add @Transactional here
    public ProjectDetailsTranslation saveTranslation(ProjectDetailsTranslation translation) {
        return projectDetailsTranslationRepository.save(translation);
    }

    public ProjectDetailsTranslation getTranslationByProjectDetailsAndLanguage(Long projectDetailsId, String languageCode) {
        return projectDetailsTranslationRepository.findByProjectDetailsIdAndLanguageName(projectDetailsId, languageCode);
    }

    public void deleteTranslation(Long id) {
        projectDetailsTranslationRepository.deleteById(id);
    }

    @Transactional  // Optionally, you can also add this for update
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

/*
package com.hamdihawari.server.project.projectDetails.service;

import com.hamdihawari.server.project.language.entity.Language;
import com.hamdihawari.server.project.language.repository.LanguageRepository;
import com.hamdihawari.server.project.projectDetails.entity.ProjectDetails;
import com.hamdihawari.server.project.projectDetails.entity.ProjectDetailsTranslation;
import com.hamdihawari.server.project.projectDetails.repository.ProjectDetailsRepository;
import com.hamdihawari.server.project.projectDetails.repository.ProjectDetailsTranslationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectDetailsTranslationService {

    @Autowired
    private ProjectDetailsTranslationRepository projectDetailsTranslationRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private ProjectDetailsRepository projectDetailsRepository;

    public Optional<ProjectDetails> findById(Long id) {
        return projectDetailsRepository.findById(id);
    }

    public List<ProjectDetailsTranslation> getAllTranslations() {
        return projectDetailsTranslationRepository.findAll();
    }

    public List<ProjectDetailsTranslation> getTranslationsByProjectDetailsId(Long projectDetailsId) {
        return projectDetailsTranslationRepository.findByProjectDetailsId(projectDetailsId);
    }

    public ProjectDetailsTranslation saveTranslation(ProjectDetailsTranslation translation) {
        return projectDetailsTranslationRepository.save(translation);
    }

    public ProjectDetailsTranslation getTranslationByProjectDetailsAndLanguage(Long projectDetailsId, String languageCode) {
        return projectDetailsTranslationRepository.findByProjectDetailsIdAndLanguageName(projectDetailsId, languageCode);
    }

    public void deleteTranslation(Long id) {
        projectDetailsTranslationRepository.deleteById(id);
    }

    // Update
    public ProjectDetailsTranslation updateTranslation(Long id, ProjectDetailsTranslation translation) {
        if (projectDetailsTranslationRepository.existsById(id)) {
            translation.setId(id); // Ensure the ID is set for the update
            return projectDetailsTranslationRepository.save(translation);
        }
        return null; // Return null if the translation with the given ID doesn't exist
    }

    public ProjectDetailsTranslation createTranslation(ProjectDetailsTranslation translation) {
        // Fetch the Language entity from the database
        Language language = languageRepository.findById(translation.getLanguage().getId())
                .orElseThrow(() -> new EntityNotFoundException("Language not found"));

        translation.setLanguage(language); // Set the existing Language instance
        return projectDetailsTranslationRepository.save(translation);
    }
}

*/
