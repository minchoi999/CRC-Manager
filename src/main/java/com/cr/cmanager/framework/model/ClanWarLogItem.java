package com.cr.cmanager.framework.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ClanWarLogItem implements Serializable {
    private String createdDate;
    private List<Participant> participants;
}
