package com.sample.Service;

import org.json.simple.JSONObject;

import com.domain.DataObject;

public interface SampleService {

    String getTimeString() throws Exception;

    JSONObject jsonFunction(DataObject dataObject) throws Exception;
}
