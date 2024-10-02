package com.hamdihawari.server.project.imageGroup.dto;
public class ImageGroupTranslationDTO {
    private Long id;
    private Long imageGroupId;  // Change to Long
    private String language;
    private String data;
    private String imageSubject;
    private String imageDescription;
    private String imageResource;  // Ensure this field exists

    // Constructor, getters, and setters
    public ImageGroupTranslationDTO(Long id, Long imageGroupId, String language, String data, String imageSubject, String imageDescription, String imageResource) {
        this.id = id;
        this.imageGroupId = imageGroupId;
        this.language = language;
        this.data = data;
        this.imageSubject = imageSubject;
        this.imageDescription = imageDescription;
        this.imageResource = imageResource;  // Ensure it's assigned
    }

    // Getters and setters...

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
