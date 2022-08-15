package com.kb.kbService;

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

@Service
@Configurable
public class KbServiceImpl implements KbService {

    @Value("${external.kb.api.url}")
    private String kbUrl;

    @Value("${external.kb.api.url.targetElement}")
    private String targetElement;

    @Autowired
    public JsoupComponent jsoupComponent;

    @Override
    public String getExchangeRate() throws Exception {
        return jsoupComponent.jsoupRequeString(kbUrl).getElementById(targetElement).html();
    }

}
