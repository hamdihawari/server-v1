package com.hamdihawari.server.project.imageGroup.dto;

public class ImageTranslationDTO {
    private Long id;
    private String language;
    private String data;
    private String imageSubject;
    private String imageDescription;
    /*private String imageResource;*/

    // Default constructor
    public ImageTranslationDTO() {}

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    /*public String getImageResource() {
        return imageResource;
    }*/

    /*public void setImageResource(String imageResource) {
        this.imageResource = imageResource;
    }*/
}
