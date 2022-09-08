package com.crawl.sc.scService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.util.JsoupComponent;
import com.util.SeleniumComponent;

@Service
public class ScServiceImpl implements ScService {

    @Value("${external.sc.api.url}")
    private String scUrl;

    @Value("${external.sc.api.url.targetElement}")
    private String targetElement;

    @Autowired
    public JsoupComponent jsoupComponent;

    @Autowired
    public SeleniumComponent seleniumComponent;

    @Override
    public String getExchangeRate() throws Exception {
        return seleniumComponent.requestUrlById(scUrl, targetElement);
    }

}
