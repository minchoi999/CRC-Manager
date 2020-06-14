package com.cr.cmanager.framework.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ClanWarLog implements Serializable {
    private List<ClanWarLogItem> items;
}
