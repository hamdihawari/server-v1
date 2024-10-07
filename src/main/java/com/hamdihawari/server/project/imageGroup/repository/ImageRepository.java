package com.hamdihawari.server.project.imageGroup.repository;

import com.hamdihawari.server.project.imageGroup.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByImageGroup_Id(Long imageGroupId);
}
