package com.outboundengine.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.outboundengine.model.PieSyncEmailAddress;
import com.outboundengine.model.SyncContact;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Custom Deserializer to detect if an item is missing or null
 */
public class SyncContactDeserializer extends JsonDeserializer<SyncContact> {

    @Override
    public SyncContact deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = jsonParser.getCodec();
        JsonNode jsonNode = objectCodec.readTree(jsonParser);

        SyncContact syncContact = new SyncContact();

        List<String> tags;

        String lname = isNull(jsonNode.get("lname")) ? null
                : isMissing(jsonNode.get("lname")) ? "Missing" : jsonNode.get("lname").asText();
        String fname = isNull(jsonNode.get("fname")) ? null
                : isMissing(jsonNode.get("fname")) ? "missing" : jsonNode.get("fname").asText();
        Long id = isNull(jsonNode.get("id")) ? new Long(0)
                : isMissing(jsonNode.get("id")) ? new Long(-1) : new Long(jsonNode.get("id").asLong());
        List<PieSyncEmailAddress> emailList = processPieSyncEmailAddress(jsonNode.get("emailList"));
        String contactSource = isNull(jsonNode.get("contactSource")) ? null
                : isMissing(jsonNode.get("contactSource")) ? "missing" : jsonNode.get("contactSource").asText();

        syncContact.setLname(lname);
        syncContact.setFname(fname);
        syncContact.setId(id);
        syncContact.setEmailList(emailList);
        syncContact.setContactSource(contactSource);
        return syncContact;
    }

    List<PieSyncEmailAddress> processPieSyncEmailAddress(JsonNode emailList) {
        List<PieSyncEmailAddress> emailAddresses = new ArrayList<PieSyncEmailAddress>();
        if (emailList != null) {
            if (emailList.isArray()) {
                ArrayNode arrayNode = (ArrayNode) emailList;
                for (int i = 0; i < arrayNode.size(); i++) {
                    JsonNode jsonNode = arrayNode.get(i);
                    Long id = isNull(jsonNode.get("id")) ? new Long(0)
                            : isMissing(jsonNode.get("id")) ? new Long(-1) : new Long(jsonNode.get("id").asLong());
                    Long contactId = isNull(jsonNode.get("contactId")) ? new Long(0)
                            : isMissing(jsonNode.get("contactId")) ? new Long(-1)
                                    : jsonNode.get("contactId").asLong();
                    String emailAddress = isNull(jsonNode.get("emailAddress")) ? null
                            : isMissing(jsonNode.get("emailAddress")) ? "missing"
                                    : jsonNode.get("emailAddress").asText();
                    String label = isNull(jsonNode.get("label")) ? null
                            : isMissing(jsonNode.get("label")) ? "missing" : jsonNode.get("label").asText();
                    Boolean isDeleted = isNull(jsonNode.get("isDeleted")) ? false
                            : isMissing(jsonNode.get("isDeleted")) ? false : jsonNode.get("isDeleted").asBoolean();
                    ZonedDateTime lastUpdated;

                    PieSyncEmailAddress pieSyncEmailAddress = new PieSyncEmailAddress();
                    pieSyncEmailAddress.setContactId(contactId);
                    pieSyncEmailAddress.setEmailAddress(emailAddress);
                    pieSyncEmailAddress.setId(id);
                    pieSyncEmailAddress.setIsDeleted(isDeleted);
                    pieSyncEmailAddress.setLabel(label);

                    emailAddresses.add(pieSyncEmailAddress);

                }

            }
        }

        return emailAddresses;
    }

    /**
     * TODO add methods for setString(JsonNode node, String elementToRetrieve)
     * TODO add methods for setLong(JsonNode node, String elementToRetrieve)
     * TODO add methods for setBoolean(JsonNode node, String elementToRetrieve)
     * Time, Integer, ...
     */
    /**
     * TODO move to abstract class that extends JsonDeserializer and extend it
     * 
     * @param node
     * @return
     */
    boolean isNull(JsonNode node) {
        boolean result = false;
        if (node != null) {
            result = node.isNull();
        }
        return result;
    }

    /**
     * TODO move to abstract class that extends JsonDeserializer and extend it
     * 
     * @param node
     * @return
     */
    boolean isMissing(JsonNode node) {
        return node == null;
    }

}
