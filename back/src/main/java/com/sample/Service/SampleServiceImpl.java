package com.sample.Service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService {

    @Override
    public String getTimeString() throws Exception {
        return LocalDateTime.now().toString();
    }

}