package com.hamdihawari.server.project.imageGroup.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "image_translation")
public class ImageTranslation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "image_id", nullable = false)
    private Image image; // Reference to the associated Image

    @Column(name = "language", nullable = false)
    private String language; // Language code (e.g., "en", "de", "ar")

    @Column(name = "data")
    private String data; // Optional additional data for the translation

    @Column(name = "image_subject")
    private String imageSubject; // Subject of the image

    @Column(name = "image_description")
    private String imageDescription; // Description of the image

    @Column(name = "image_resource", nullable = false)
    private String imageResource; // Resource link for the image

    // Default constructor
    public ImageTranslation() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getImageSubject() {
        return imageSubject;
    }

    public void setImageSubject(String imageSubject) {
        this.imageSubject = imageSubject;
    }

    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }

    public String getImageResource() {
        return imageResource;
    }

    public void setImageResource(String imageResource) {
        this.imageResource = imageResource;
    }
}
