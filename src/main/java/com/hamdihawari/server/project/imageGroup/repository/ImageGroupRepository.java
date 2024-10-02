package com.hamdihawari.server.project.imageGroup.repository;

import com.hamdihawari.server.project.imageGroup.entity.ImageGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageGroupRepository extends JpaRepository<ImageGroup, Long> {
}
