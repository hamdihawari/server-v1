package com.hamdihawari.server.project.imageGroup.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hamdihawari.server.project.projectDetails.entity.ProjectDetails; // Ensure this is the correct import
import jakarta.persistence.*;

@Entity
@Table(name = "image_group")
public class ImageGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_detail_id", nullable = false)
    private Long projectDetailId;

    @ManyToOne
    @JoinColumn(name = "project_detail_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonBackReference // This prevents infinite recursion
    private ProjectDetails projectDetail;

    public ImageGroup() {
    }

    public ImageGroup(Long projectDetailId) {
        this.projectDetailId = projectDetailId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectDetailId() {
        return projectDetailId;
    }

    public void setProjectDetailId(Long projectDetailId) {
        this.projectDetailId = projectDetailId;
    }

    public ProjectDetails getProjectDetail() {
        return projectDetail;
    }

    public void setProjectDetail(ProjectDetails projectDetail) {
        this.projectDetail = projectDetail;
    }
}
