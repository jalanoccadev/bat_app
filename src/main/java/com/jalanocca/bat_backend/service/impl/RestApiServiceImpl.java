package com.jalanocca.bat_backend.service.impl;

import com.jalanocca.bat_backend.service.RestApiService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.Map;

@Service
public class RestApiServiceImpl implements RestApiService {

    private final RestTemplate restTemplate;

    public RestApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public <T> T get(String baseUrl, String api, Map<String, String> headers, Map<String, String> params, Class<T> responseType) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseUrl + api);
        if (params != null) {
            params.forEach(builder::queryParam);
        }
        String url = builder.toUriString();
        HttpHeaders httpHeaders = buildHeaders(headers);
        HttpEntity<Void> entity = new HttpEntity<>(httpHeaders);
        ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.GET, entity, responseType);
        return response.getBody();
    }

    @Override
    public <T> T post(String baseUrl, String api, Map<String, String> headers, Object body, Class<T> responseType) {
        String url = baseUrl + api;
        HttpHeaders httpHeaders = buildHeaders(headers);
        HttpEntity<Object> entity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.POST, entity, responseType);
        return response.getBody();
    }

    private HttpHeaders buildHeaders(Map<String, String> headers) {
        HttpHeaders httpHeaders = new HttpHeaders();
        if (headers != null && !headers.isEmpty()) {
            headers.forEach(httpHeaders::add);
        }
        return httpHeaders;
    }
}
