package com.hamdihawari.server.gallery.ImageGallery.entity;

import com.hamdihawari.server.project.language.entity.Language;
import jakarta.persistence.*;

@Entity
@Table(name = "image_gallery_translation", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"image_gallery_id", "language_id"})
})
public class ImageGalleryTranslation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "image_gallery_id", nullable = false)
    private ImageGallery imageGallery;

    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

    private String title;
    private String location;
    private String originalAlt;
    private String thumbnailAlt;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ImageGallery getImageGallery() {
        return imageGallery;
    }

    public void setImageGallery(ImageGallery imageGallery) {
        this.imageGallery = imageGallery;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOriginalAlt() {
        return originalAlt;
    }

    public void setOriginalAlt(String originalAlt) {
        this.originalAlt = originalAlt;
    }

    public String getThumbnailAlt() {
        return thumbnailAlt;
    }

    public void setThumbnailAlt(String thumbnailAlt) {
        this.thumbnailAlt = thumbnailAlt;
    }
}
