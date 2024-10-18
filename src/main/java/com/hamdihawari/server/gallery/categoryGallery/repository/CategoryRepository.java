package com.hamdihawari.server.gallery.categoryGallery.repository;

import com.hamdihawari.server.gallery.categoryGallery.entiry.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Custom query methods can be added here if needed
}
