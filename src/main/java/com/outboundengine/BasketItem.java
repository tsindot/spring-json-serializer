package com.outboundengine;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.outboundengine.json.BasketItemDeserializer;
import com.outboundengine.json.BasketItemSerializer;

/**
 * 
 *
 * If you want to use serialization by annotation you have to uncomment the two annotations
 * below and comment the @Service in BasketItemJsonModule.
 */
//@JsonDeserialize(using = BasketItemDeserializer.class)
//@JsonSerialize(using = BasketItemSerializer.class)
public class BasketItem {
  private String product;
  private String code;
  private int amount;

  /*
  {“lname”:“Contact574",“fname”:“User”,“emailList”:[{“email”:“sample_contact_xyz5711e@example.net”,“deleted”:false,“id”:0}],“contactSource”:“PieSync”,“tags”:[]}
  */

  public BasketItem() {
  }

  public String getProduct() { return product; }

  public void setProduct(String product) {
    this.product = product;
  }

  public String getCode() { return code; }

  public void setCode(String code) {
    this.code = code;
  }

  public int getAmount() { return amount; }

  public void setAmount(int amount) {
    this.amount = amount;
  }
}

