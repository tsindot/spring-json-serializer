package com.outboundengine;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * 
 */
@RestController
public class BasketController {
  @RequestMapping(path = "/addToBasket")
  public List<BasketItem> addToBasket(@RequestBody BasketItem basketItem) {
    return Arrays.asList(basketItem);
  }
}

