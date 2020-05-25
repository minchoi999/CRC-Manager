package com.cr.cmanager.framework.service;

import com.cr.cmanager.ApplicationConfiguration;
import lombok.NonNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class ClashRoyaleRestServiceAdapter<ResponseType> extends RestServiceAdapter<ResponseType> {

    @NonNull
    private RestTemplate restTemplate;
    @NonNull
    private ApplicationConfiguration appConfig;

    private HttpHeaders httpHeaders;

    public ClashRoyaleRestServiceAdapter(final RestTemplate restTemplate,
                                         final ApplicationConfiguration appConfig) {
        super(restTemplate);
        this.restTemplate = restTemplate;
        this.appConfig = appConfig;
        this.httpHeaders = buildHeaders();
    }

    protected ResponseEntity<ResponseType> get(final Class<ResponseType> clazz,
                                               final String url,
                                               final Object... params) throws RestClientException {
        return get(clazz, httpHeaders, url, params);
    }

    protected ResponseEntity<ResponseType> post(final Class<ResponseType> clazz,
                                                final String url,
                                                final Object... params) throws RestClientException {
        return post(clazz, httpHeaders, url, params);
    }

    protected ResponseEntity<ResponseType> put(final Class<ResponseType> clazz,
                                               final String url,
                                               final Object... params) throws RestClientException {
        return put(clazz, httpHeaders, url, params);
    }

    private HttpHeaders buildHeaders() {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.setBearerAuth(appConfig.getClashRoyaleApiKey());

        return httpHeaders;
    }
}
