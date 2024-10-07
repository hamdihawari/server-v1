package com.hamdihawari.server.project.imageGroup.dto;

public class ImageDTO {
    private Long id;
    private String imagePath;

    // Default constructor
    public ImageDTO() {}

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
