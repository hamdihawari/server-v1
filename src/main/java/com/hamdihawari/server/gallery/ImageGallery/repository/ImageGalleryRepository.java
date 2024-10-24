package com.hamdihawari.server.gallery.ImageGallery.repository;

import com.hamdihawari.server.gallery.ImageGallery.entity.ImageGallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface ImageGalleryRepository extends JpaRepository<ImageGallery, Long> {

    @Query("SELECT ig FROM ImageGallery ig " +
            "JOIN ig.category c " +
            "JOIN CategoryTranslation ct ON ct.category.id = c.id " +
            "WHERE ct.name = :categoryName AND ct.language.id = :languageId")
    List<ImageGallery> findByCategoryNameAndLanguage(@Param("categoryName") String categoryName, @Param("languageId") Long languageId);

    @Query("SELECT ig FROM ImageGallery ig " +
            "JOIN ig.category c " +
            "JOIN CategoryTranslation ct ON ct.category.id = c.id " +
            "WHERE ct.name = :categoryName")
    List<ImageGallery> findByCategoryName(@Param("categoryName") String categoryName);
}
