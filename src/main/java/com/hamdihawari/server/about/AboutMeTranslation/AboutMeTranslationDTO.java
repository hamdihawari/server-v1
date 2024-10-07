package com.hamdihawari.server.about.AboutMeTranslation;

public class AboutMeTranslationDTO {

    private Long id;
    private Long aboutMeId;
    private String title;
    private String description;
    private String subject;
    private String language;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAboutMeId() {
        return aboutMeId;
    }

    public void setAboutMeId(Long aboutMeId) {
        this.aboutMeId = aboutMeId;
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
