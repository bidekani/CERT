package com.karamat.jaxrs.model;

import java.util.Date;

public class CertExt {
    private int extId;

    private int certId;
    private String extensionNo;
    private String status;
    private String issueDate;
    private String expDate;
    private String extComment;
    private String productClass;
    private String spStart;
    private String markingLabelsCheck;
    private String savedBy;
    private String savedDate;
    private String expDateNa;
    private Date   releaseDate;
    private Date   created;
    private String createdBy;

    public int getExtId() {
        return extId;
    }
    public void setExtId(int extId) {
        this.extId = extId;
    }
    public int getCertId() {
        return certId;
    }
    public void setCertId(int certId) {
        this.certId = certId;
    }
    public String getExtensionNo() {
        return extensionNo;
    }
    public void setExtensionNo(String extensionNo) {
        this.extensionNo = extensionNo;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getIssueDate() {
        return issueDate;
    }
    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }
    public String getExpDate() {
        return expDate;
    }
    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }
    public String getExtComment() {
        return extComment;
    }
    public void setExtComment(String extComment) {
        this.extComment = extComment;
    }
    public String getProductClass() {
        return productClass;
    }
    public void setProductClass(String productClass) {
        this.productClass = productClass;
    }
    public String getSpStart() {
        return spStart;
    }
    public void setSpStart(String spStart) {
        this.spStart = spStart;
    }
    public String getMarkingLabelsCheck() {
        return markingLabelsCheck;
    }
    public void setMarkingLabelsCheck(String markingLabelsCheck) {
        this.markingLabelsCheck = markingLabelsCheck;
    }
    public String getSavedBy() {
        return savedBy;
    }
    public void setSavedBy(String savedBy) {
        this.savedBy = savedBy;
    }
    public String getSavedDate() {
        return savedDate;
    }
    public void setSavedDate(String savedDate) {
        this.savedDate = savedDate;
    }
    public String getExpDateNa() {
        return expDateNa;
    }
    public void setExpDateNa(String expDateNa) {
        this.expDateNa = expDateNa;
    }
    public Date getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

}
