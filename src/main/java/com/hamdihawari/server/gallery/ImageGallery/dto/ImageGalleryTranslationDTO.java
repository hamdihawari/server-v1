package com.hamdihawari.server.gallery.ImageGallery.dto;

public class ImageGalleryTranslationDTO {

    private Long id;
    private Long imageGalleryId;
    private Long languageId;
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

    public Long getImageGalleryId() {
        return imageGalleryId;
    }

    public void setImageGalleryId(Long imageGalleryId) {
        this.imageGalleryId = imageGalleryId;
    }

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
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
