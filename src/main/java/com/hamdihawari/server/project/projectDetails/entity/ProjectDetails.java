package com.hamdihawari.server.project.projectDetails.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "project_details")
public class ProjectDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_card_id", nullable = false)
    private Long projectCardId;

    public ProjectDetails() {
    }

    // Constructor for creating ProjectDetails with ID
    public ProjectDetails(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectCardId() {
        return projectCardId;
    }

    public void setProjectCardId(Long projectCardId) {
        this.projectCardId = projectCardId;
    }
}
