package com.hamdihawari.server.project.imageGroup.repository;

import com.hamdihawari.server.project.imageGroup.entity.ImageTranslation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImageTranslationRepository extends JpaRepository<ImageTranslation, Long> {

    // Find by language code
    @Query("SELECT it FROM ImageTranslation it WHERE it.language.code = :languageCode")
    List<ImageTranslation> findByLanguageCode(@Param("languageCode") String languageCode);

    // Find by image ID
    List<ImageTranslation> findByImageId(Long imageId);

    // Find by image ID and language code
    @Query("SELECT it FROM ImageTranslation it WHERE it.image.id = :imageId AND it.language.code = :languageCode")
    List<ImageTranslation> findByImageIdAndLanguageCode(@Param("imageId") Long imageId, @Param("languageCode") String languageCode);

    // Find by language ID
    List<ImageTranslation> findByLanguageId(Long languageId);
}

/*
package com.hamdihawari.server.project.imageGroup.repository;

import com.hamdihawari.server.project.imageGroup.entity.ImageTranslation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImageTranslationRepository extends JpaRepository<ImageTranslation, Long> {

    // Find by language code
    @Query("SELECT it FROM ImageTranslation it WHERE it.language.code = :languageCode")
    List<ImageTranslation> findByLanguageCode(@Param("languageCode") String languageCode);

    // Find by image ID
    List<ImageTranslation> findByImageId(Long imageId);

    // Find by image ID and language code
    @Query("SELECT it FROM ImageTranslation it WHERE it.image.id = :imageId AND it.language.code = :languageCode")
    List<ImageTranslation> findByImageIdAndLanguageCode(@Param("imageId") Long imageId, @Param("languageCode") String languageCode);

    // Find by language ID
    List<ImageTranslation> findByLanguageId(Long languageId);
}
*/
