package com.cr.cmanager.framework.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Location implements Serializable {
    private long id;
    private String name;
    private boolean isCountry;
    private String countryCode;
}
