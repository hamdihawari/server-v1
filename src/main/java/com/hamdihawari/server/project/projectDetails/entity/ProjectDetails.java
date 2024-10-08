package com.hamdihawari.server.project.projectDetails.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hamdihawari.server.project.imageGroup.entity.ImageGroup;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "project_details")
public class ProjectDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_card_id", nullable = false)
    private Long projectCardId;

    // Prevent circular reference when serializing
    @OneToMany(mappedBy = "projectDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference // Controls serialization from ProjectDetails to ProjectDetailsTranslation
    private List<ProjectDetailsTranslation> translations;

    @OneToMany(mappedBy = "projectDetail", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore // Prevents serialization of this relationship to avoid unnecessary recursion
    private List<ImageGroup> imageGroups;

    public ProjectDetails() {
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProjectDetailsTranslation> getTranslations() {
        return translations;
    }

    public void setTranslations(List<ProjectDetailsTranslation> translations) {
        this.translations = translations;
    }

    public List<ImageGroup> getImageGroups() {
        return imageGroups;
    }

    public void setImageGroups(List<ImageGroup> imageGroups) {
        this.imageGroups = imageGroups;
    }

    public Long getProjectCardId() {
        return projectCardId;
    }

    public void setProjectCardId(Long projectCardId) {
        this.projectCardId = projectCardId;
    }
}
