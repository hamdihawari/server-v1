package com.hamdihawari.server.project.projectDetails.dto;

public class ProjectDetailsDTO {
    private Long id;
    private Long projectCardId; // assuming you're referencing the projectCard ID

    // Getters and Setters
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
