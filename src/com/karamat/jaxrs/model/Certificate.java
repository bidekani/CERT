package com.karamat.jaxrs.model;

import java.util.Date;

public class Certificate {
    private int id;

    private String description;
    private String regulation;
    private String supplier;
    private String createdBy;
    private Date   created;
    private String certNo;
    private String regArea;
    private String modifiedBy;
    private Date   modifiedDate;
    private String contactInfo;
    private int    supplierId;
    private String certType;
    private String context;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getRegulation() {
        return regulation;
    }
    public void setRegulation(String regulation) {
        this.regulation = regulation;
    }
    public String getSupplier() {
        return supplier;
    }
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
    public String getCertNo() {
        return certNo;
    }
    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }
    public String getRegArea() {
        return regArea;
    }
    public void setRegArea(String regArea) {
        this.regArea = regArea;
    }
    public String getModifiedBy() {
        return modifiedBy;
    }
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
    public Date getModifiedDate() {
        return modifiedDate;
    }
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
    public String getContactInfo() {
        return contactInfo;
    }
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
    public int getSupplierId() {
        return supplierId;
    }
    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }
    public String getCertType() {
        return certType;
    }
    public void setCertType(String certType) {
        this.certType = certType;
    }
    public String getContext() {
        return context;
    }
    public void setContext(String context) {
        this.context = context;
    }

}
