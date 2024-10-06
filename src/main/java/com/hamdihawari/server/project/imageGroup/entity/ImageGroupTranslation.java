package com.hamdihawari.server.project.imageGroup.entity;

import jakarta.persistence.*;

@Entity
public class ImageGroupTranslation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "image_group_id", nullable = false)
    private ImageGroup imageGroup;

    @Column(nullable = false, length = 5)
    private String language;

    @Column(columnDefinition = "TEXT")
    private String data;

    @Column(name = "image_subject", length = 255)
    private String imageSubject;

    @Column(name = "image_description", columnDefinition = "TEXT")
    private String imageDescription;

    @Column(name = "image_resource", nullable = false, length = 255)
    private String imageResource;

    // Getters and Setters

    public ImageGroupTranslation() {
    }

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
