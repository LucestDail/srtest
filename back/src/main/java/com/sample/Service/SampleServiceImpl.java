package com.sample.Service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.domain.DataObject;
import com.google.gson.JsonObject;

@Service
public class SampleServiceImpl implements SampleService {

    @Override
    public String getTimeString() throws Exception {
        return LocalDateTime.now().toString();
    }

    @Override
    public JsonObject jsonFunction(DataObject dataObject) throws Exception {
        System.out.println(dataObject);
        JsonObject jsonObject = new JsonObject();
        return null;
    }

}