package com.hamdihawari.server.about.AboutMeTranslation;

import com.hamdihawari.server.about.AboutMe.AboutMe;
import jakarta.persistence.*;


@Entity
@Table(name = "about_me_translation")
public class AboutMeTranslation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "about_me_id", nullable = false)
    private AboutMe aboutMe;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "subject", nullable = false)
    private String subject;

    @Column(name = "language", nullable = false, length = 10)
    private String language;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AboutMe getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(AboutMe aboutMe) {
        this.aboutMe = aboutMe;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
