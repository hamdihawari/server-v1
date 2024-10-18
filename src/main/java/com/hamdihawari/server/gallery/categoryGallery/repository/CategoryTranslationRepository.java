package com.hamdihawari.server.gallery.categoryGallery.repository;

import com.hamdihawari.server.gallery.categoryGallery.entiry.CategoryTranslation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryTranslationRepository extends JpaRepository<CategoryTranslation, Long> {

    @Query("SELECT t FROM CategoryTranslation t WHERE t.category.id = :categoryId AND t.language.id = :languageId")
    Optional<CategoryTranslation> findByCategoryIdAndLanguageId(@Param("categoryId") Long categoryId, @Param("languageId") Long languageId);

    // Fetch by just languageId for all categories
    @Query("SELECT t FROM CategoryTranslation t WHERE t.language.id = :languageId")
    List<CategoryTranslation> findByLanguageId(@Param("languageId") Long languageId);
}
