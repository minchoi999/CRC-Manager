package com.cr.cmanager.framework.service;

import com.cr.cmanager.framework.exception.InvalidRequestException;

public interface ServiceAdapter<RequestType, ResponseType> {

    ResponseType call(RequestType request) throws InvalidRequestException;
}
