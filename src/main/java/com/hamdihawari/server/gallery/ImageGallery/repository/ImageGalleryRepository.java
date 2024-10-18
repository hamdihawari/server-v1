package com.hamdihawari.server.gallery.ImageGallery.repository;

import com.hamdihawari.server.gallery.ImageGallery.entity.ImageGallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageGalleryRepository extends JpaRepository<ImageGallery, Long> {
    // Custom query methods can be added here if needed
}
