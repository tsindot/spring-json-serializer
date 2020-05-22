package com.outboundengine.model;

import java.util.List;

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
public class SyncContact {
    private String lname;
    private String fname;
    private Long id;
    private List<PieSyncEmailAddress> emailList;
    private String contactSource;
    private List<String> tags;

    public SyncContact() {
    }

    /**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @param lname the lname to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
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
     * @return the emaliList
     */
    public List<PieSyncEmailAddress> getEmailList() {
        return emailList;
    }

    /**
     * @param emaliList the emaliList to set
     */
    public void setEmailList(List<PieSyncEmailAddress> emaliList) {
        this.emailList = emaliList;
    }

    /**
     * @return the contactSource
     */
    public String getContactSource() {
        return contactSource;
    }

    /**
     * @param contactSource the contactSource to set
     */
    public void setContactSource(String contactSource) {
        this.contactSource = contactSource;
    }

    /**
     * @return the tags
     */
    public List<String> getTags() {
        return tags;
    }

    /**
     * @param tags the tags to set
     */
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "SyncContact [contactSource=" + contactSource + ", emailList=" + emailList + ", fname=" + fname + ", id="
                + id + ", lname=" + lname + ", tags=" + tags + "]";
    }
}
