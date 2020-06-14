package com.cr.cmanager.clan.service;

import com.cr.cmanager.ApplicationConfiguration;
import com.cr.cmanager.framework.exception.InvalidRequestException;
import com.cr.cmanager.framework.model.Clan;
import com.cr.cmanager.framework.model.ClanWarLog;
import com.cr.cmanager.framework.service.ClashRoyaleRestServiceAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

@Component
public class ClashRoyaleClanWarLogRestServiceAdapter extends ClashRoyaleRestServiceAdapter<String, ClanWarLog> {
    private static final String CLAN_TAG_PARAMTER_KEY = "clanTag";
    private static final String CLAN_PATH_TEMPLATE = String.format("v1/clans/{%s}/warlog", CLAN_TAG_PARAMTER_KEY);
    private static final String CLAN_TAG_PREFIX = "#";

    @Autowired
    public ClashRoyaleClanWarLogRestServiceAdapter(final RestTemplate restTemplate,
                                             final ApplicationConfiguration appConfig) {
        super(restTemplate, appConfig);
    }

    @Override
    public ClanWarLog call(final String clanTag) throws InvalidRequestException {
        if (StringUtils.isEmpty(clanTag)) {
            throw new InvalidRequestException("Clan tag cannot be empty.");
        }

        final String urlTemplate = buildUrlTemplate(CLAN_PATH_TEMPLATE);
        final ResponseEntity<ClanWarLog> clanResponseEntity= get(ClanWarLog.class, urlTemplate, getFormattedClanTag(clanTag));
        System.out.println(clanResponseEntity.getBody());
        return clanResponseEntity.getBody();
    }

    private String getFormattedClanTag(final String clanTag) {
        if (clanTag.indexOf(CLAN_TAG_PREFIX) == 0) {
            return clanTag;
        } else {
            return CLAN_TAG_PREFIX + clanTag;
        }
    }
}


