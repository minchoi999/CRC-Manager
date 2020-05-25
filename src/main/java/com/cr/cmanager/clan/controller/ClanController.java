package com.cr.cmanager.clan.controller;

import com.cr.cmanager.clan.service.ClashRoyaleClanRestServiceAdapter;
import com.cr.cmanager.framework.model.Clan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClanController {

    @Autowired
    private ClashRoyaleClanRestServiceAdapter adapter;

    @RequestMapping("/")
    public String index() {

        final ResponseEntity<Clan> clanResponse = adapter.getClanData("#PPJ0Y88Q");

        return clanResponse.getBody().toString();
    }
}
