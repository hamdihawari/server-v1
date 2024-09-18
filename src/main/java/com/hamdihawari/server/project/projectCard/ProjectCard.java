
package com.hamdihawari.server.project.projectCard;

import com.hamdihawari.server.language.Language;
import jakarta.persistence.*;

@Entity
@Table(name = "project_card")
public class ProjectCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String path;

    @Column(nullable = false)
    private String title;

    @Column
    private String icon;

    @Column
    private String data;

    @Column
    private String image;

    @Column
    private String imageHover;

    @Column
    private String subject;

    @Column(nullable = false, length = 1000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "language_id", referencedColumnName = "id")
    private Language language;

    public ProjectCard(){
    }

    public ProjectCard(Long id, String path, String title, String icon, String data, String image, String imageHover, String subject, String description, Language language) {
        this.id = id;
        this.path = path;
        this.title = title;
        this.icon = icon;
        this.data = data;
        this.image = image;
        this.imageHover = imageHover;
        this.subject = subject;
        this.description = description;
        this.language = language;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "ProjectCard{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", title='" + title + '\'' +
                ", icon='" + icon + '\'' +
                ", data='" + data + '\'' +
                ", image='" + image + '\'' +
                ", imageHover='" + imageHover + '\'' +
                ", subject='" + subject + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

