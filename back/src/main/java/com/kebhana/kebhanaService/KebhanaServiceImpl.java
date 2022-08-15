package com.kebhana.kebhanaService;

import java.net.URI;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.util.RestComponent;

@Service
public class KebhanaServiceImpl implements KebhanaService {

    @Value("${external.kebHana.api.url}")
    private String kebHanaUrl;

    @Override
    public String getKebhanaExchangeRate() throws Exception {
        URI uri = UriComponentsBuilder
                .fromUriString(kebHanaUrl)
                .encode()
                .build()
                .toUri();
        RestComponent rc = new RestComponent();

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(rc.getRequest(uri).replace("var exView = ", ""));

        return json.toJSONString();
    }

}
