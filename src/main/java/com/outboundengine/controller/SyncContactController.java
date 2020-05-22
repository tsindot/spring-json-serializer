package com.outboundengine.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import com.outboundengine.model.SyncContact;

/**
 * 
 */
@RestController
public class SyncContactController {
    
  @RequestMapping(path = "/syncToContact")
  public List<SyncContact> syncToContact(@RequestBody SyncContact syncContct) {
    return Arrays.asList(syncContct);
  }
}