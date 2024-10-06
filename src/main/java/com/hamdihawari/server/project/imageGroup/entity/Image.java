package com.hamdihawari.server.project.imageGroup.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // Assuming many images belong to one image group
    @JoinColumn(name = "image_group_id") // Ensure the correct foreign key name
    private ImageGroup imageGroup;

    @Column(name = "image_path")
    private String imagePath;

    public Image() {
    }

    public Image(Long id, ImageGroup imageGroup, String imagePath) {
        this.id = id;
        this.imageGroup = imageGroup;
        this.imagePath = imagePath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ImageGroup getImageGroup() {
        return imageGroup;
    }

    public void setImageGroup(ImageGroup imageGroup) {
        this.imageGroup = imageGroup;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
