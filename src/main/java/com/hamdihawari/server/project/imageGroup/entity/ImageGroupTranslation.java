package com.hamdihawari.server.project.imageGroup.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "image_group_translation")
public class ImageGroupTranslation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image_group_id")
    private Long imageGroupId;  // Change to Long

    @Column(name = "language")
    private String language;

    @Column(name = "data")
    private String data;

    @Column(name = "image_subject")
    private String imageSubject;

    @Column(name = "image_description")
    private String imageDescription;

    @Column(name = "image_resource", nullable = false)
    private String imageResource;

    // Constructors, getters, and setters

    public ImageGroupTranslation() {
    }

    public ImageGroupTranslation(Long imageGroupId, String language, String data, String imageSubject, String imageDescription, String imageResource) {
        this.imageGroupId = imageGroupId;
        this.language = language;
        this.data = data;
        this.imageSubject = imageSubject;
        this.imageDescription = imageDescription;
        this.imageResource = imageResource;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getImageGroupId() {
        return imageGroupId;
    }

    public void setImageGroupId(Long imageGroupId) {
        this.imageGroupId = imageGroupId;
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
