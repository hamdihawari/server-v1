package com.hamdihawari.server.project.imageGroup.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "image_translation")
public class ImageTranslation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "image_id", referencedColumnName = "id", nullable = false)
    private Image image;

    @Column(name = "language", nullable = false)
    private String language;

    @Column(name = "data")
    private String data;

    @Column(name = "image_subject")
    private String imageSubject;

    @Column(name = "image_description")
    private String imageDescription;

   /* @Column(name = "image_resource", nullable = false)
    private String imageResource;*/

    // Default constructor
    public ImageTranslation() {}

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
/*
    public String getImageResource() {
        return imageResource;
    }

    public void setImageResource(String imageResource) {
        this.imageResource = imageResource;
    }*/
}
