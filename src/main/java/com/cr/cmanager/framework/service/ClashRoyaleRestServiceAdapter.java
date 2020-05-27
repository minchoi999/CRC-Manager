package com.cr.cmanager.framework.service;

import com.cr.cmanager.ApplicationConfiguration;
import lombok.NonNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public abstract class ClashRoyaleRestServiceAdapter<RequestType, ResponseType> extends RestServiceAdapter<RequestType, ResponseType> {

    @NonNull
    private final ApplicationConfiguration appConfig;

    public ClashRoyaleRestServiceAdapter(final RestTemplate restTemplate,
                                         final ApplicationConfiguration appConfig) {
        super(restTemplate);
        this.appConfig = appConfig;
    }

    protected ResponseEntity<ResponseType> get(final Class<ResponseType> clazz,
                                               final String urlTemplate,
                                               final Object... params) throws RestClientException {
        return get(clazz, buildHeaders(), urlTemplate, params);
    }

    protected ResponseEntity<ResponseType> post(final Class<ResponseType> clazz,
                                                final String urlTemplate,
                                                final Object... params) throws RestClientException {
        return post(clazz, buildHeaders(), urlTemplate, params);
    }

    protected ResponseEntity<ResponseType> put(final Class<ResponseType> clazz,
                                               final String urlTemplate,
                                               final Object... params) throws RestClientException {
        return put(clazz, buildHeaders(), urlTemplate, params);
    }

    @Override
    protected HttpHeaders buildHeaders() {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.setBearerAuth(appConfig.getClashRoyaleApiKey());

        return httpHeaders;
    }
}
