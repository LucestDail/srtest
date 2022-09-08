package com.crawl.city.cityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.util.JsoupComponent;

@Service
public class CityServiceImpl implements CityService {

    @Value("${external.city.api.url}")
    private String cityUrl;

    @Value("${external.city.api.url.targetElement}")
    private String targetElement;

    @Autowired
    public JsoupComponent jsoupComponent;

    @Override
    public String getExchangeRate() throws Exception {
        return jsoupComponent.jsoupRequeString(cityUrl).getElementById(targetElement).html();
    }

}
