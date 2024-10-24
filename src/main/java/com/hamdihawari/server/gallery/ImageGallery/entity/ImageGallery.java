package com.hamdihawari.server.gallery.ImageGallery.entity;

import com.hamdihawari.server.gallery.categoryGallery.entiry.Category;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import java.util.Date;

@Entity
@Table(name = "image_gallery")
public class ImageGallery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String original;

    @Column(nullable = false, length = 255)
    private String thumbnail;

    @Column(name = "taken")
    private LocalDate taken;  // Use LocalDate for dates

    @Column(name = "camera_make", length = 100)
    private String cameraMake;

    @Column(name = "camera_model", length = 100)
    private String cameraModel;

    @Column(name = "lens", length = 20)
    private String lens;

    @Column(name = "aperture", length = 10)
    private String aperture;

    @Column(name = "lens_type", length = 50)
    private String lensType;

    @Column(name = "autofocus")
    private Boolean autofocus;

    @Column(name = "shutter_speed", length = 20)
    private String shutterSpeed;

    @Column(name = "flash_used")
    private Boolean flashUsed;

    @Column(name = "iso_value")
    private Integer isoValue;

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private ZonedDateTime createdAt = ZonedDateTime.now();

    @Column(name = "updated_at", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private ZonedDateTime updatedAt = ZonedDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "fk_image_gallery_category"), nullable = false)
    private Category category;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
