package com.shinhan.shinhanService;

import org.springframework.stereotype.Service;

import com.util.SeleniumComponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Service
public class ShinhanServiceImpl implements ShinhanService {

    @Value("${external.shinhan.api.url}")
    private String url;

    @Autowired
    public SeleniumComponent seleniumComponent;

    @Override
    public String getExchangeRate() throws Exception {
        return seleniumComponent.requestUrlById(url, "grd_list_1");
    }

}
