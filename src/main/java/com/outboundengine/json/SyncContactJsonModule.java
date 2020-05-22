package com.outboundengine.json;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.outboundengine.model.SyncContact;

import org.springframework.stereotype.Service;

@Service
public class SyncContactJsonModule extends SimpleModule {
    private static final long serialVersionUID = 1L;

    public SyncContactJsonModule() {
      this.addDeserializer(SyncContact.class, new SyncContactDeserializer());
      this.addSerializer(SyncContact.class, new SyncContactSerializer());
    }
      
}