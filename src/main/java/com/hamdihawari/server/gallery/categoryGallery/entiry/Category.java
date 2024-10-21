package com.hamdihawari.server.gallery.categoryGallery.entiry;
import com.hamdihawari.server.gallery.ImageGallery.entity.ImageGallery;
import jakarta.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private ZonedDateTime createdAt;

    @Column(name = "updated_at", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private ZonedDateTime updatedAt;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImageGallery> imageGalleries;

    // Constructor
    public Category() {
        this.createdAt = ZonedDateTime.now(); // Initialize with current timestamp
        this.updatedAt = ZonedDateTime.now();
    }

    // Lifecycle callbacks to handle createdAt and updatedAt
    @PrePersist
    protected void onCreate() {
        this.createdAt = ZonedDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = ZonedDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<ImageGallery> getImageGalleries() {
        return imageGalleries;
    }

    public void setImageGalleries(List<ImageGallery> imageGalleries) {
        this.imageGalleries = imageGalleries;
    }
}
