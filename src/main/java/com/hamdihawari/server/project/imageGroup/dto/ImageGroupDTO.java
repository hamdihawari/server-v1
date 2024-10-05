package com.hamdihawari.server.project.imageGroup.dto;

public class ImageGroupDTO {

    private Long id;
    private Long projectDetailId;

    public ImageGroupDTO() {
    }

    public ImageGroupDTO(Long id, Long projectDetailId) {
        this.id = id;
        this.projectDetailId = projectDetailId;
    }

    public ImageGroupDTO(Long id) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectDetailId() {
        return projectDetailId;
    }

    public void setProjectDetailId(Long projectDetailId) {
        this.projectDetailId = projectDetailId;
    }
}
