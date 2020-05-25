package com.cr.cmanager.framework.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RequiredArgsConstructor
public abstract class RestServiceAdapter<ResponseType> {

    @NonNull
    private final RestTemplate restTemplate;

    protected ResponseEntity<ResponseType> get(final Class<ResponseType> clazz,
                                               final HttpHeaders headers,
                                               final String url,
                                               final Object... params) throws RestClientException {
        final HttpEntity<String> httpEntity = buildHttpEntity(headers);

        return restTemplate.exchange(url, HttpMethod.GET, httpEntity, clazz, params);
    }

    protected ResponseEntity<ResponseType> post(final Class<ResponseType> clazz,
                                                final HttpHeaders headers,
                                                final String url,
                                                final Object... params) throws RestClientException {
        final HttpEntity<String> httpEntity = buildHttpEntity(headers);

        return restTemplate.exchange(url, HttpMethod.POST, httpEntity, clazz, params);
    }

    protected ResponseEntity<ResponseType> put(final Class<ResponseType> clazz,
                                               final HttpHeaders headers,
                                               final String url,
                                               final Object... params) throws RestClientException {
        final HttpEntity<String> httpEntity = buildHttpEntity(headers);

        return restTemplate.exchange(url, HttpMethod.PUT, httpEntity, clazz, params);
    }

    private HttpEntity buildHttpEntity(final HttpHeaders headers) {
        return new HttpEntity<>(headers);
    }
}
