package com.hamdihawari.server.project.projectCard.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "project_card")
public class ProjectCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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