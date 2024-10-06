package com.hamdihawari.server.project.imageGroup.repository;

import com.hamdihawari.server.project.imageGroup.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    // Additional query methods can be defined here if needed
}
