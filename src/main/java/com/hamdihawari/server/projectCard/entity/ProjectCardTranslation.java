package com.hamdihawari.server.projectCard.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "project_card_translation")


    public class ProjectCardTranslationDTO {
        private Long projectCardId;
        private Long languageId;
        private String subject;
        private String data;
        private String description;

        // Getters and Setters
        public Long getProjectCardId() {
            return projectCardId;
        }

        public void setProjectCardId(Long projectCardId) {
            this.projectCardId = projectCardId;
        }

        public Long getLanguageId() {
            return languageId;
        }

        public void setLanguageId(Long languageId) {
            this.languageId = languageId;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
