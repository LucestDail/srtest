package com.sample.Service;

import com.domain.DataObject;
import com.google.gson.JsonObject;

public interface SampleService {

    String getTimeString() throws Exception;

    JsonObject jsonFunction(DataObject dataObject) throws Exception;
}
