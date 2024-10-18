package com.hamdihawari.server.gallery.ImageGallery.repository;

import com.hamdihawari.server.gallery.ImageGallery.entity.ImageGalleryTranslation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageGalleryTranslationRepository extends JpaRepository<ImageGalleryTranslation, Long> {

    // Find translations by languageId
    @Query("SELECT t FROM ImageGalleryTranslation t WHERE t.language.id = :languageId")
    List<ImageGalleryTranslation> findByLanguageId(@Param("languageId") Long languageId);

    // Find translations by imageGalleryId
    List<ImageGalleryTranslation> findByImageGalleryId(Long imageGalleryId);

    // Find a translation by imageGalleryId and languageId
    @Query("SELECT t FROM ImageGalleryTranslation t WHERE t.imageGallery.id = :imageGalleryId AND t.language.id = :languageId")
    Optional<ImageGalleryTranslation> findByImageGalleryIdAndLanguageId(@Param("imageGalleryId") Long imageGalleryId, @Param("languageId") Long languageId);
}


/*
package com.hamdihawari.server.gallery.ImageGallery.repository;

import com.hamdihawari.server.gallery.ImageGallery.entity.ImageGalleryTranslation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageGalleryTranslationRepository extends JpaRepository<ImageGalleryTranslation, Long> {
    // Custom query methods can be added here if needed
}
*/
