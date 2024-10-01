package com.hamdihawari.server.project.projectDetails.dto;

public class ProjectDetailsTranslationDTO {

    private Long projectDetailsId;
    private Long languageId;
    private String subjectDetails;
    private String cardDescription;

    public Long getProjectDetailsId() {
        return projectDetailsId;
    }

    public void setProjectDetailsId(Long projectDetailsId) {
        this.projectDetailsId = projectDetailsId;
    }

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    public String getSubjectDetails() {
        return subjectDetails;
    }

    public void setSubjectDetails(String subjectDetails) {
        this.subjectDetails = subjectDetails;
    }

    public String getCardDescription() {
        return cardDescription;
    }

    public void setCardDescription(String cardDescription) {
        this.cardDescription = cardDescription;
    }
}
