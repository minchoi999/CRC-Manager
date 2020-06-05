package com.cr.cmanager.clan.controller;

import com.cr.cmanager.clan.service.ClashRoyaleClanRestServiceAdapter;
import com.cr.cmanager.framework.exception.InvalidRequestException;
import com.cr.cmanager.framework.model.Clan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClanController {

    @Autowired
    private ClashRoyaleClanRestServiceAdapter adapter;

    @RequestMapping("/clan/{clanTag}")
    public Clan index(@PathVariable("clanTag") final String clanTag) throws InvalidRequestException {
        try {
            return adapter.call(clanTag);
        } catch (final Exception e) {
            throw e;
        }
    }
}
