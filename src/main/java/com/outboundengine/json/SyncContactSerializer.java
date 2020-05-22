package com.outboundengine.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.outboundengine.model.PieSyncEmailAddress;
import com.outboundengine.model.SyncContact;

import java.io.IOException;


public class SyncContactSerializer extends JsonSerializer<SyncContact> {
  @Override
  public void serialize(
    SyncContact syncContact, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
    throws IOException, JsonProcessingException {

    System.out.println(syncContact);
    jsonGenerator.writeStartObject();
    jsonGenerator.writeStringField("lname", syncContact.getLname());
    jsonGenerator.writeStringField("fname", syncContact.getFname());
    jsonGenerator.writeFieldName("emailList");
    jsonGenerator.writeStartArray();
    for(PieSyncEmailAddress address : syncContact.getEmailList()) {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("email", address.getEmailAddress());
        jsonGenerator.writeBooleanField("deleted", address.getIsDeleted());
        jsonGenerator.writeNumberField("id", address.getId());
        jsonGenerator.writeEndObject();
    }
    jsonGenerator.writeEndArray();
    jsonGenerator.writeStringField("fname", syncContact.getContactSource());
    jsonGenerator.writeEndObject();
    System.out.println("finished serialize...");
  }
}