package com.outboundengine.json;

import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.outboundengine.BasketItem;
import org.junit.Test;

/**
 * 
 */
public class BasketItemTest {
  @Test
  public void deserialize() throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new BasketItemJsonModule());

    BasketItem basketItem = objectMapper.readValue(
      "{\"detail\": {\"product\": \"car\", \"code\": \"car-01\"}, \"amount\": 1}",
      BasketItem.class);

    assertEquals("car" , basketItem.getProduct());
    assertEquals("car-01", basketItem.getCode());
    assertEquals(1, basketItem.getAmount());
  }

  @Test
  public void serialize() throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new BasketItemJsonModule());

    BasketItem basketItem = new BasketItem();
    basketItem.setAmount(5);
    basketItem.setProduct("car");
    basketItem.setCode("car-02");

    String json = objectMapper.writeValueAsString(basketItem);
    assertEquals("{\"detail\":{\"product\":\"car\",\"code\":\"car-02\"},\"amount\":5}", json);
  }

@Test
public void deserializeIsFieldNullOrMissing() throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new BasketItemJsonModule());

    BasketItem basketItem = objectMapper.readValue(
      "{\"detail\": {\"product\":null}, \"amount\": 1}",
      BasketItem.class);

    System.out.println(basketItem.getProduct());
    System.out.println(basketItem.getCode());
    System.out.println(basketItem.getAmount());

    assertEquals(null , basketItem.getProduct());
    assertEquals("missing", basketItem.getCode());
    assertEquals(1, basketItem.getAmount());
  }

}