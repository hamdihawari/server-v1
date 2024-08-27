package com.hamdihawari.server.about;

import jakarta.persistence.*;

@Entity
    @Table(name = "about_me")
    public class AboutMe {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String language;

        @Column(nullable = false)
        private String photo;

        @Column(nullable = false)
        private String title;

        @Column(nullable = false, length = 1000)
        private String description;


    public AboutMe() {

    }

    public AboutMe(Long id, String language, String photo, String title, String description) {
        this.id = id;
        this.language = language;
        this.photo = photo;
        this.title = title;
        this.description = description;
    }

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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "AboutMe{" +
                "id=" + id +
                ", language='" + language + '\'' +
                ", photo='" + photo + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
