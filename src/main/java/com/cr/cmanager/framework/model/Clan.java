package com.cr.cmanager.framework.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Clan implements Serializable {
    private String tag;
    private String name;
    private String type;
    private String description;
    private long badgeId;
    private long clanScore;
    private int clanWarTrophies;
    private Location location;
    private int requiredTrophies;
    private int donationsPerWeek;
    private String clanChestStatus;
    private int clanChestLevel;
    private int clanChestMaxLevel;
    private int members;
    private List<ClanMember> memberList;
}
