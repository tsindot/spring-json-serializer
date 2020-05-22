package com.outboundengine.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.outboundengine.BasketItem;

import java.io.IOException;

/**
 * 
 */
public class BasketItemDeserializer extends JsonDeserializer<BasketItem> {
  @Override
  public BasketItem deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
    throws IOException, JsonProcessingException {
    ObjectCodec objectCodec = jsonParser.getCodec();
    JsonNode jsonNode = objectCodec.readTree(jsonParser);

    BasketItem basketItem = new BasketItem();
    String product = isNull(jsonNode.get("detail").get("product")) ? null : 
            isMissing(jsonNode.get("detail").get("product")) ? "Missing" : 
            jsonNode.get("detail").get("product").asText();
    String code = isNull(jsonNode.get("detail").get("code")) ? "field null" : 
            isMissing(jsonNode.get("detail").get("code")) ? "missing" : 
            jsonNode.get("detail").get("code").asText();
    int amount = isNull(jsonNode.get("amount")) ? 0 : 
            isMissing(jsonNode.get("amount")) ? -1 : 
            jsonNode.get("amount").asInt();

    System.out.println("product = " + product);
    System.out.println("code = " + code);
    System.out.println("amount = " + amount);

    basketItem.setProduct(product);
    basketItem.setCode(code);
    basketItem.setAmount(amount);

    return basketItem;
  }

  boolean isNull(JsonNode node) {
      boolean result = false;
      if (node != null) {
        result = node.isNull();
      }
      return result;
  }

  boolean isMissing(JsonNode node) {
      return node == null;
  }

}
