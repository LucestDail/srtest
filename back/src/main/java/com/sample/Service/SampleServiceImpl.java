package com.sample.Service;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.domain.DataObject;

@Service
public class SampleServiceImpl implements SampleService {

    @Override
    public String getTimeString() throws Exception {
        return LocalDateTime.now().toString();
    }

    @Override
    public JSONObject jsonFunction(DataObject dataObject) throws Exception {
        return dataObject.getJson();
    }

}