package com.jalanocca.bat_backend.service;

import java.util.Map;

public interface RestApiService {
    <T> T get(String baseUrl, String api, Map<String, String> headers, Map<String, String> params, Class<T> responseType);
    <T> T post(String baseUrl, String api, Map<String, String> headers, Object body, Class<T> responseType);
}
