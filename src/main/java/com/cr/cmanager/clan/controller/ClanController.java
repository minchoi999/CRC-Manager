package com.cr.cmanager.clan.controller;

import com.cr.cmanager.clan.service.ClashRoyaleClanRestServiceAdapter;
import com.cr.cmanager.framework.exception.InvalidRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClanController {

    @Autowired
    private ClashRoyaleClanRestServiceAdapter adapter;

    @RequestMapping("/")
    public String index() {
        try {
            return adapter.call("#PPJ0Y88Q").toString();
        } catch (final InvalidRequestException e) {
            return "Invalid request";
        } catch (final Exception e) {
            return "Unknown error";
        }
    }
}
