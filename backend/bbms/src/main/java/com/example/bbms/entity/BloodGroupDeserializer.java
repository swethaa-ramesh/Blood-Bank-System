package com.example.bbms.entity;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class BloodGroupDeserializer extends JsonDeserializer<Request.BloodGroup> {
    @Override
    public Request.BloodGroup deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getValueAsString();
        if (value == null) {
            return null;
        }
        return Request.BloodGroup.fromDisplayName(value);
    }
} 