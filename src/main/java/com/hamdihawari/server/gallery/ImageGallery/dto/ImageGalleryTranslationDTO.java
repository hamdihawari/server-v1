package com.hamdihawari.server.gallery.ImageGallery.dto;

import java.util.Date;

public class ImageGalleryTranslationDTO {

    private Long id;
    private Long imageGalleryId;
    private Long languageId;
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
package com.hamdihawari.server.gallery.ImageGallery.dto;

import java.util.Date;

public class ImageGalleryTranslationDTO {
    private Long id;                   // ID der Übersetzung
    private Long imageGalleryId;       // Verknüpfung zur Bildgalerie
    private Long languageId;           // Verknüpfung zur Sprache
    private Date taken;                // Datum, an dem das Bild aufgenommen wurde
    private String camera;             // Kamera
    private String objective;          // Objektiv
    private String title;              // Titel des Bildes
    private String location;           // Ort, an dem das Bild aufgenommen wurde
    private String originalAlt;        // Alt-Text für das Originalbild
    private String thumbnailAlt;       // Alt-Text für das Thumbnail

    // Getter und Setter
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

    public Date getTaken() {
        return taken;
    }

    public void setTaken(Date taken) {
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
