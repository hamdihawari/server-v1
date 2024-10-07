package com.hamdihawari.server.project.imageGroup.entity;

import com.hamdihawari.server.project.projectDetails.entity.ProjectDetails;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "image_group")
public class ImageGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_detail_id", nullable = false)
    private Long projectDetailId;

    @ManyToOne
    @JoinColumn(name = "project_detail_id", insertable = false, updatable = false)  // Marking it read-only
    private ProjectDetails projectDetail;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "imageGroup", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Image> images;

    // Default constructor
    public ImageGroup() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
