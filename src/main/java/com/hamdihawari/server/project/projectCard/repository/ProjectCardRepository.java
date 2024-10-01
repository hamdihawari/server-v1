package com.hamdihawari.server.project.projectCard.repository;

import com.hamdihawari.server.project.projectCard.entity.ProjectCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectCardRepository extends JpaRepository<ProjectCard, Long> {
}