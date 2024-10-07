package com.hamdihawari.server.about.AboutMeTranslation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AboutMeTranslationRepository extends JpaRepository<AboutMeTranslation, Long> {
    List<AboutMeTranslation> findByAboutMeId(Long aboutMeId);
}
