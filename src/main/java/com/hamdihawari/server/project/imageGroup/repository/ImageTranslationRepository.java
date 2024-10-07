package com.hamdihawari.server.project.imageGroup.repository;

import com.hamdihawari.server.project.imageGroup.entity.ImageTranslation;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

@Repository
public interface ImageTranslationRepository extends JpaRepository<ImageTranslation, Long> {
}
