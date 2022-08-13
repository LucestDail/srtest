package com.kebhana.kebhanaService;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
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
    @Override
    public String getKebhanaExchangeRate() throws Exception {
        URI uri = UriComponentsBuilder
                .fromUriString("http://fx.kebhana.com/FER1101M.web")
                .encode()
                .build()
                .toUri();
        RestComponent rc = new RestComponent();
        return rc.getRequest(uri).replace("var exView = ", "");
    }

}
