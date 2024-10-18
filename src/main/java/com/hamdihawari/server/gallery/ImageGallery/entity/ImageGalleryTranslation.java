package com.hamdihawari.server.gallery.ImageGallery.entity;

import com.hamdihawari.server.project.language.entity.Language;
import jakarta.persistence.*;
import java.util.Date;

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

    private Date taken;
    private String cameraMake;
    private String cameraModel;
    private String lensFocalLength;
    private String lensAperture;
    private String imageStabilizer;
    private String lensType;
    private Boolean autofocus;
    private String shutterSpeed;
    private Integer isoValue;
    private String whiteBalance;
    private String meteringMode;
    private Boolean flashUsed;
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

    public Date getTaken() {
        return taken;
    }

    public void setTaken(Date taken) {
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

    public String getLensFocalLength() {
        return lensFocalLength;
    }

    public void setLensFocalLength(String lensFocalLength) {
        this.lensFocalLength = lensFocalLength;
    }

    public String getLensAperture() {
        return lensAperture;
    }

    public void setLensAperture(String lensAperture) {
        this.lensAperture = lensAperture;
    }

    public String getImageStabilizer() {
        return imageStabilizer;
    }

    public void setImageStabilizer(String imageStabilizer) {
        this.imageStabilizer = imageStabilizer;
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

    public Integer getIsoValue() {
        return isoValue;
    }

    public void setIsoValue(Integer isoValue) {
        this.isoValue = isoValue;
    }

    public String getWhiteBalance() {
        return whiteBalance;
    }

    public void setWhiteBalance(String whiteBalance) {
        this.whiteBalance = whiteBalance;
    }

    public String getMeteringMode() {
        return meteringMode;
    }

    public void setMeteringMode(String meteringMode) {
        this.meteringMode = meteringMode;
    }

    public Boolean getFlashUsed() {
        return flashUsed;
    }

    public void setFlashUsed(Boolean flashUsed) {
        this.flashUsed = flashUsed;
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

/*
package com.hamdihawari.server.gallery.ImageGallery.entity;

import com.hamdihawari.server.project.language.entity.Language;
import jakarta.persistence.*;

@Entity
@Table(name = "image_gallery_translation", uniqueConstraints = {@UniqueConstraint(columnNames = {"image_gallery_id", "language_id"})})
public class ImageGalleryTranslation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_gallery_id", foreignKey = @ForeignKey(name = "fk_image_gallery_translation_gallery"))
    private ImageGallery imageGallery;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id", foreignKey = @ForeignKey(name = "fk_image_gallery_translation_language"))
    private Language language;

    @Column(name = "taken")
    private String taken;

    @Column(name = "camera", length = 100)
    private String camera;

    @Column(name = "objective", length = 100)
    private String objective;

    @Column(name = "title", length = 255)
    private String title;

    @Column(name = "location", length = 255)
    private String location;

    @Column(name = "original_alt", length = 255)
    private String originalAlt;

    @Column(name = "thumbnail_alt", length = 255)
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

    public String getTaken() {
        return taken;
    }

    public void setTaken(String taken) {
        this.taken = taken;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
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
*/
