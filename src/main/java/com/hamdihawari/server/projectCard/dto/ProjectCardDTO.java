package com.hamdihawari.server.projectCard.dto;

import com.hamdihawari.server.projectCard.entity.ProjectCard;
import com.hamdihawari.server.projectCard.entity.ProjectCardTranslation;
import java.util.List;

public class ProjectCardDTO {

    private Long id;
    private String path;
    private String icon;
    private String image;
    private String imageHover;

    // Getter und Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageHover() {
        return imageHover;
    }

    public void setImageHover(String imageHover) {
        this.imageHover = imageHover;
    }
}
