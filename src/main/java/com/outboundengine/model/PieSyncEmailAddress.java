package com.outboundengine.model;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.outboundengine.json.SyncContactDeserializer;
import com.outboundengine.json.SyncContactSerializer;

/**
 * 
 *
 * If you want to use serialization by annotation you have to uncomment the two
 * annotations below and comment the @Service in SyncContactJsonModule.
 */
// @JsonDeserialize(using = SyncContactDeserializer.class)
// @JsonSerialize(using = SyncContactSerializer.class)
public class PieSyncEmailAddress {
    private Long id;
    private Long contactId;
    private String emailAddress;
    private String label;
    private Boolean isDeleted;
    private ZonedDateTime lastUpdated;

    public PieSyncEmailAddress() {
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the contactId
     */
    public Long getContactId() {
        return contactId;
    }

    /**
     * @param contactId the contactId to set
     */
    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return the isDeleted
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * @param isDeleted the isDeleted to set
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * @return the lastUpdated
     */
    public ZonedDateTime getLastUpdated() {
        return lastUpdated;
    }

    /**
     * @param lastUpdated the lastUpdated to set
     */
    public void setLastUpdated(ZonedDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "PieSyncEmailAddress [contactId=" + contactId + ", emailAddress=" + emailAddress + ", id=" + id
                + ", isDeleted=" + isDeleted + ", label=" + label + ", lastUpdated=" + lastUpdated + "]";
    }

}