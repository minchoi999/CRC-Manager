package com.cr.cmanager.clan.controller;

import com.cr.cmanager.clan.service.ClashRoyaleClanRestServiceAdapter;
import com.cr.cmanager.clan.service.ClashRoyaleClanWarLogRestServiceAdapter;
import com.cr.cmanager.framework.exception.InvalidRequestException;
import com.cr.cmanager.framework.model.Clan;
import com.cr.cmanager.framework.model.ClanWarLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClanMemberParticipationController {

    @Autowired
    private ClashRoyaleClanRestServiceAdapter clanAdapter;
    @Autowired
    private ClashRoyaleClanWarLogRestServiceAdapter clanWarLogAdapter;

    @RequestMapping("/clan/{clanTag}/clanWarLog")
    public ClanWarLog index(@PathVariable("clanTag") final String clanTag) throws InvalidRequestException {
        try {
            return clanWarLogAdapter.call(clanTag);
        } catch (final Exception e) {
            throw e;
        }
    }
}

