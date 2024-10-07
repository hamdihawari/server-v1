package com.hamdihawari.server.project.imageGroup.entity;

import com.hamdihawari.server.project.projectDetails.entity.ProjectDetails;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "image_group")
public class ImageGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)  // Lazy fetching for better performance
    @JoinColumn(name = "project_detail_id", nullable = false)
    private ProjectDetails projectDetail;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "imageGroup", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Image> images = new ArrayList<>();

    // Constructors
    public ImageGroup() {
        // Automatically set createdAt on object creation
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

    public ProjectDetails getProjectDetail() {
        return projectDetail;
    }

    public void setProjectDetail(ProjectDetails projectDetail) {
        this.projectDetail = projectDetail;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Optional: Remove the setter for createdAt to prevent it from being updated
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

    // Utility methods for managing images in the group
    public void addImage(Image image) {
        images.add(image);
        image.setImageGroup(this);
    }

    public void removeImage(Image image) {
        images.remove(image);
        image.setImageGroup(null);
    }

    // Lifecycle callback to update the updatedAt timestamp automatically
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
