package com.outboundengine.json;

import static org.junit.Assert.assertEquals;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.outboundengine.model.PieSyncEmailAddress;
import com.outboundengine.model.SyncContact;
import org.junit.Test;

/**
 * 
 */
public class SyncContactJsonIsMissingOrNullTest {

  static final String allFieldsJson = "{\"lname\":\"Contact574\",\"fname\":\"User\",\"emailList\":[{\"email\":\"sample_contact_xyz5711e@example.net\",\"deleted\":false,\"id\":0}],\"contactSource\":\"PieSync\",\"tags\":[]}";

  static final String nullFieldsJson = "{\"lname\":null,\"fname\":null,\"emailList\":[{\"email\":\"sample_contact_xyz5711e@example.net\",\"deleted\":false,\"id\":0}],\"contactSource\":\"PieSync\",\"tags\":[]}";

  static final String missingFieldsJson = "{\"fname\":\"User\",\"emailList\":[{\"email\":\"sample_contact_xyz5711e@example.net\",\"deleted\":false,\"id\":0}],\"contactSource\":\"PieSync\",\"tags\":[]}";

  static final String missingAndNullFieldsJson = "{\"fname\":null,\"emailList\":[{\"email\":\"sample_contact_xyz5711e@example.net\",\"deleted\":false,\"id\":0}],\"contactSource\":\"PieSync\",\"tags\":[]}";

  @Test
  public void deserialize() throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new SyncContactJsonModule());

    SyncContact syncContact = objectMapper.readValue(allFieldsJson, SyncContact.class);

    assertEquals("Contact574", syncContact.getLname());
    assertEquals("User", syncContact.getFname());
    assertEquals(1, syncContact.getEmailList().size());
  }

  @Test
  public void serialize() throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new SyncContactJsonModule());

    SyncContact syncContact = new SyncContact();
    PieSyncEmailAddress pieSyncEmail = new PieSyncEmailAddress();
    List<PieSyncEmailAddress> emails = new ArrayList<PieSyncEmailAddress>();

    syncContact.setLname("May");
    syncContact.setFname("Bellalou");
    syncContact.setContactSource("TestContactSource");
    syncContact.setId(10L);
    pieSyncEmail.setId(9L);
    pieSyncEmail.setLabel("lable here");
    pieSyncEmail.setLastUpdated(ZonedDateTime.now());
    pieSyncEmail.setContactId(123L);
    pieSyncEmail.setEmailAddress("bellaloumay@gmail.com");
    pieSyncEmail.setIsDeleted(false);
    emails.add(pieSyncEmail);
    syncContact.setTags(new ArrayList<String>());
    syncContact.setEmailList(emails);
    String json = objectMapper.writeValueAsString(syncContact);

    System.out.println(json);
    //assertEquals("{\"detail\":{\"product\":\"car\",\"code\":\"car-02\"},\"amount\":5}", json);
  }

@Test
public void deserializeIsFieldNullOrMissing() throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new SyncContactJsonModule());

    SyncContact syncContact = objectMapper.readValue(missingAndNullFieldsJson,
        SyncContact.class);

    assertEquals("Missing" , syncContact.getLname());
    assertEquals(null, syncContact.getFname());
    assertEquals(1, syncContact.getEmailList().size());

  }

}