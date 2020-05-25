package com.cr.cmanager.framework.service;

import lombok.NonNull;
import org.springframework.web.client.RestTemplate;

public interface ServiceAdapter<ResponseType> {

    public ResponseType callService(String url);
}
