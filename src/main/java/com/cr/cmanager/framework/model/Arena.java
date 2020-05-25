package com.cr.cmanager.framework.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Arena implements Serializable {
    private String name;
    private long id;
}
