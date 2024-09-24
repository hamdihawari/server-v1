package com.hamdihawari.server.project.imageGroup;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageGroupRepository extends JpaRepository<ImageGroup, Long> {
    List<ImageGroup> findByProjectDetailsId(Long projectDetailsId);
}
