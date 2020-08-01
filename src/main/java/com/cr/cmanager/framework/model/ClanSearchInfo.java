package com.cr.cmanager.framework.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

public class ClanSearchInfo {
    private List<ClanMember> memberList;
    private List<ClanWarLogItem> items;
    private String tag;
    private String name;
    private String type;
    private String description;
    private long badgeId;
    private long clanScore;
    private int clanWarTrophies;
}
