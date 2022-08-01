package com.domain;

import java.util.Map;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
@JsonPOJOBuilder
public class DataObject {

    Map<String, Object> header;
    Map<String, Object> body;

    public JSONObject getJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("header", this.header);
        jsonObject.put("body", this.body);
        return jsonObject;
    }

    public boolean isError() {
        return (boolean) this.header.get("errorFlag");
    }

}
