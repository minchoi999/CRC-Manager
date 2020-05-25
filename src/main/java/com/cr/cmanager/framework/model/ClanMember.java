package com.cr.cmanager.framework.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClanMember implements Serializable {
    private Arena arena;
    private int clanChestPoints;
    private String lastSeen;
    private String tag;
    private String role;
    private int expLevel;
    private int trophies;
    private int clanRank;
    private int previousClanRank;
    private int donations;
    private int donationsReceived;
}
