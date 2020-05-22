package com.outboundengine.json;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.outboundengine.BasketItem;
import org.springframework.stereotype.Service;

/**
 * Created by rainerh on 20.11.16.
 */
@Service
public class BasketItemJsonModule extends SimpleModule {
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public BasketItemJsonModule() {
    this.addDeserializer(BasketItem.class, new BasketItemDeserializer());
    this.addSerializer(BasketItem.class, new BasketItemSerializer());
  }
}
