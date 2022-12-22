package com.crawl.knb.knbService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.util.JsoupComponent;
import com.util.SeleniumComponent;

@Service
public class KnbServiceImpl implements KnbService {

    @Value("${external.knb.api.url}")
    private String knbUrl;

    @Value("${external.knb.api.url.targetElement}")
    private String targetElement;

    @Autowired
    public JsoupComponent jsoupComponent;

    // @Autowired
    // public SeleniumComponent seleniumComponent;

    @Override
    public String getExchangeRate() throws Exception {
        // return seleniumComponent.requestUrlById(knbUrl, targetElement);
        return null;
    }

}
