package com.hamdihawari.server.project.imageGroup.repository;

import com.hamdihawari.server.project.imageGroup.entity.ImageGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageGroupRepository extends JpaRepository<ImageGroup, Long> {
    List<ImageGroup> findByProjectDetailId(Long projectDetailId);
}
