
package com.hamdihawari.server.projectCard.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProjectCardTranslationDTO {

    private Long id;

    @NotNull
    private Long projectCardId;

    @NotNull
    private Long languageId;

    @Size(max = 255)
    private String subject;

    @Size(max = 255)
    private String data;

    @Size(max = 500)
    private String description;

    public ProjectCardTranslationDTO() {
    }

    public ProjectCardTranslationDTO(Long id, Long projectCardId, Long languageId, String subject, String data, String description) {
        this.id = id;
        this.projectCardId = projectCardId;
        this.languageId = languageId;
        this.subject = subject;
        this.data = data;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull Long getProjectCardId() {
        return projectCardId;
    }

    public void setProjectCardId(@NotNull Long projectCardId) {
        this.projectCardId = projectCardId;
    }

    public @NotNull Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(@NotNull Long languageId) {
        this.languageId = languageId;
    }

    public @Size(max = 255) String getSubject() {
        return subject;
    }

    public void setSubject(@Size(max = 255) String subject) {
        this.subject = subject;
    }

    public @Size(max = 255) String getData() {
        return data;
    }

    public void setData(@Size(max = 255) String data) {
        this.data = data;
    }

    public @Size(max = 500) String getDescription() {
        return description;
    }

    public void setDescription(@Size(max = 500) String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProjectCardTranslationDTO{" +
                "id=" + id +
                ", projectCardId=" + projectCardId +
                ", languageId=" + languageId +
                ", subject='" + subject + '\'' +
                ", data='" + data + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}