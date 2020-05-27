package com.cr.cmanager.framework.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import static com.cr.cmanager.framework.Constant.CR_API_BASE_URL;
import static com.cr.cmanager.framework.Constant.HTTPS;

@RequiredArgsConstructor
public abstract class RestServiceAdapter<RequestType, ResponseType> implements ServiceAdapter<RequestType, ResponseType>{

    @NonNull
    private final RestTemplate restTemplate;

    protected ResponseEntity<ResponseType> get(final Class<ResponseType> clazz,
                                               final HttpHeaders httpHeaders,
                                               final String urlTemplate,
                                               final Object... params) throws RestClientException {
        return restTemplate.exchange(urlTemplate, HttpMethod.GET, new HttpEntity<>(httpHeaders), clazz, params);
    }

    protected ResponseEntity<ResponseType> post(final Class<ResponseType> clazz,
                                                final HttpHeaders httpHeaders,
                                                final String urlTemplate,
                                                final Object... params) throws RestClientException {
        return restTemplate.exchange(urlTemplate, HttpMethod.POST, new HttpEntity<>(httpHeaders), clazz, params);
    }

    protected ResponseEntity<ResponseType> put(final Class<ResponseType> clazz,
                                               final HttpHeaders httpHeaders,
                                               final String urlTemplate,
                                               final Object... params) throws RestClientException {
        return restTemplate.exchange(urlTemplate, HttpMethod.PUT, new HttpEntity<>(httpHeaders), clazz, params);
    }

    protected String buildUrlTemplate(final String pathTemplate) {
        final UriComponents uriComponents = UriComponentsBuilder
                .newInstance()
                .scheme(HTTPS)
                .host(CR_API_BASE_URL)
                .path(pathTemplate)
                .build();

        return uriComponents.toUriString();
    }

    protected abstract HttpHeaders buildHeaders();
}
