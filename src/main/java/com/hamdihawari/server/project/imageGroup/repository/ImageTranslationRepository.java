package com.hamdihawari.server.project.imageGroup.repository;

import com.hamdihawari.server.project.imageGroup.entity.ImageTranslation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageTranslationRepository extends JpaRepository<ImageTranslation, Long> {
    List<ImageTranslation> findByLanguage(String language);
}
