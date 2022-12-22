package com.crawl.woori.wooriService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.util.JsoupComponent;
import com.util.SeleniumComponent;

@Service
public class WooriServiceImpl implements WooriService {

    @Value("${external.woori.api.url}")
    private String wooriUrl;

    @Value("${external.woori.api.url.targetElement}")
    private String targetElement;

    @Autowired
    public JsoupComponent jsoupComponent;

    // @Autowired
    // public SeleniumComponent seleniumComponent;

    @Override
    public String getExchangeRate() throws Exception {
        // return seleniumComponent.requestUrlById(wooriUrl, targetElement);
        return null;
    }

}
