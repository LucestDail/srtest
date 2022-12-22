package com.crawl.dcinside.service;

import java.net.URI;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.util.JsoupComponent;
import com.util.RestComponent;
import com.util.SeleniumComponent;

@Service
@Configurable
public class DcinsideServiceImpl implements DcinsideService {

    @Value("${external.dcinside.api.url}")
    private String dcinsideUrl;

    @Value("${external.dcinside.api.urletc}")
    private String dcinsideUrlEtc;

    @Value("${external.dcinside.api.url.targetElement}")
    private String dcinsideTargetElemenString;

    @Autowired
    public JsoupComponent jsoupComponent;

    // @Autowired
    // public SeleniumComponent seleniumComponent;

    @Override
    public String getPage(String page) throws Exception {
        // return seleniumComponent.requestUrlbyClass(dcinsideUrl + page +
        // dcinsideUrlEtc, dcinsideTargetElemenString);
        return null;
    }

}
