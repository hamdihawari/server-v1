package com.hamdihawari.server.project.projectDetails.entity;

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

    /*@OneToMany(mappedBy = "projectDetail", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ImageGroup> imageGroups;*/
    @OneToMany(mappedBy = "projectDetail", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference // This is the managed side of the relationship
    private List<ImageGroup> imageGroups;
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

    public List<ImageGroup> getImageGroups() {
        return imageGroups;
    }

    public void setImageGroups(List<ImageGroup> imageGroups) {
        this.imageGroups = imageGroups;
    }
}
