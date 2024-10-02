package com.hamdihawari.server.project.imageGroup.dto;

public class ImageDTO {

    private Long id;
    private Long imageGroupId;
    private String imagePath;

    public ImageDTO() {
    }

    public ImageDTO(Long id, Long imageGroupId, String imagePath) {
        this.id = id;
        this.imageGroupId = imageGroupId;
        this.imagePath = imagePath;
    }

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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
