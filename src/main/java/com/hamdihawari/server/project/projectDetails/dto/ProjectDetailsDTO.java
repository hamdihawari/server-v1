package com.hamdihawari.server.project.projectDetails.dto;

import com.hamdihawari.server.project.imageGroup.dto.ImageGroupDTO;

import java.util.List;

public class ProjectDetailsDTO {
    private Long id;
    private Long projectCardId; // assuming you're referencing the projectCard ID
    private List<ImageGroupDTO> imageGroups;
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

    public List<ImageGroupDTO> getImageGroups() {
        return imageGroups;
    }

    public void setImageGroups(List<ImageGroupDTO> imageGroups) {
        this.imageGroups = imageGroups;
    }
}
