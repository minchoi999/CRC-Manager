package com.cr.cmanager.framework.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Participant implements Serializable {
    private String tag;
    private String name;
    private int cardsEarned;
    private int battlesPlayed;
    private int wins;
    private int collectionDayBattlesPlayed;
    private int numberOfBattles;
}
