package com.koreaexim.koreaeximService;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class KoreaeximServiceImpl implements KoreaeximService {

    @Value("${external.koreaexim.api.url}")
    private String url;

    @Value("${external.koreaexim.api.name}")
    private String name;

    @Value("${external.koreaexim.api.key}")
    private String apiKey;

    @Override
    public String getKoreaeximExchangeRate(String date) {
        // https://www.koreaexim.go.kr/site/program/financial/exchangeJSON?authkey=RpQ2hjrXVsPZN5IDSlMum5Lwm7VwKUot&searchdate=20220811&data=AP01
        URI uri = UriComponentsBuilder
                .fromUriString("https://www.koreaexim.go.kr")
                .path("/site/program/financial/exchangeJSON")
                .queryParam("authkey", apiKey)
                .queryParam("searchdate", date)
                .queryParam("data", "AP01")
                .encode()
                .build()
                .toUri();
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(5000); // 타임아웃 설정 5초
        factory.setReadTimeout(5000);// 타임아웃 설정 5초
        RestTemplate restTemplate = new RestTemplate(factory);

        HttpHeaders header = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(header);

        ResponseEntity<String> responseEntityResult = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity,
                String.class);
        return responseEntityResult.getBody();
    }

}
