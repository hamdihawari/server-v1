package com.hamdihawari.server.project.imageGroup.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "image_group_id", nullable = false)
    private ImageGroup imageGroup; // Reference to the associated ImageGroup

    @Column(name = "image_path", nullable = false)
    private String imagePath; // Path to the image file

    @OneToMany(mappedBy = "image", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ImageTranslation> translations; // List of translations for this image

    // Default constructor
    public Image() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ImageGroup getImageGroup() {
        return imageGroup;
    }

    public void setImageGroup(ImageGroup imageGroup) {
        this.imageGroup = imageGroup;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<ImageTranslation> getTranslations() {
        return translations;
    }

    public void setTranslations(List<ImageTranslation> translations) {
        this.translations = translations;
    }
}
