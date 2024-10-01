package com.hamdihawari.server.project.projectDetails.repository;

import com.hamdihawari.server.project.projectDetails.entity.ProjectDetailsTranslation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectDetailsTranslationRepository extends JpaRepository<ProjectDetailsTranslation, Long> {
    List<ProjectDetailsTranslation> findByProjectDetailsId(Long projectDetailsId);
    List<ProjectDetailsTranslation> findByProjectDetailsIdAndLanguageId(Long projectDetailsId, Long languageId);

    // Updated method to find by project details ID and language code
    ProjectDetailsTranslation findByProjectDetailsIdAndLanguageName(Long projectDetailsId, String languageName);
}
