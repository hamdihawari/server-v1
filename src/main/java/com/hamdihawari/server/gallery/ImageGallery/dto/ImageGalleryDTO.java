package com.hamdihawari.server.gallery.ImageGallery.dto;

import jakarta.persistence.Column;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import java.util.Date;

public class ImageGalleryDTO {

    private Long id;
    private String original;
    private String thumbnail;
    private LocalDate taken;
    private String cameraMake;
    private String cameraModel;
    private String lens;
    private String aperture;
    private String lensType;
    private Boolean autofocus;
    private String shutterSpeed;
    private Boolean flashUsed;
    private Integer isoValue;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private Long categoryId;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public LocalDate getTaken() {
        return taken;
    }

    public void setTaken(LocalDate taken) {
        this.taken = taken;
    }

    public String getCameraMake() {
        return cameraMake;
    }

    public void setCameraMake(String cameraMake) {
        this.cameraMake = cameraMake;
    }

    public String getCameraModel() {
        return cameraModel;
    }

    public void setCameraModel(String cameraModel) {
        this.cameraModel = cameraModel;
    }

    public String getLens() {
        return lens;
    }

    public void setLens(String lens) {
        this.lens = lens;
    }

    public String getAperture() {
        return aperture;
    }

    public void setAperture(String aperture) {
        this.aperture = aperture;
    }

    public String getLensType() {
        return lensType;
    }

    public void setLensType(String lensType) {
        this.lensType = lensType;
    }

    public Boolean getAutofocus() {
        return autofocus;
    }

    public void setAutofocus(Boolean autofocus) {
        this.autofocus = autofocus;
    }

    public String getShutterSpeed() {
        return shutterSpeed;
    }

    public void setShutterSpeed(String shutterSpeed) {
        this.shutterSpeed = shutterSpeed;
    }

    public Boolean getFlashUsed() {
        return flashUsed;
    }

    public void setFlashUsed(Boolean flashUsed) {
        this.flashUsed = flashUsed;
    }

    public Integer getIsoValue() {
        return isoValue;
    }

    public void setIsoValue(Integer isoValue) {
        this.isoValue = isoValue;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
