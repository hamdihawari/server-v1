package com.hamdihawari.server.project.projectCard.repository;

import com.hamdihawari.server.project.projectCard.entity.ProjectCardTranslation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectCardTranslationRepository extends JpaRepository<ProjectCardTranslation, Long> {
    ProjectCardTranslation findByProjectCardIdAndLanguageId(Long projectCardId, Long languageId);
}
