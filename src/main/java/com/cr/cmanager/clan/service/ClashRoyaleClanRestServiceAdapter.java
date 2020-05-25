package com.cr.cmanager.clan.service;

import com.cr.cmanager.ApplicationConfiguration;
import com.cr.cmanager.framework.model.Clan;
import com.cr.cmanager.framework.service.ClashRoyaleRestServiceAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.security.InvalidParameterException;

import static com.cr.cmanager.framework.Constant.*;

@Component
public class ClashRoyaleClanRestServiceAdapter extends ClashRoyaleRestServiceAdapter<Clan> {

    private static final String CLAN_TAG_PREFIX = "#";
    private static final String CLAN_TAG_PARAMTER_KEY = "clanTag";
    private static final String CLAN_PATH_TEMPLATE = String.format("v1/clans/{%s}", CLAN_TAG_PARAMTER_KEY);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ApplicationConfiguration appConfig;

    public ClashRoyaleClanRestServiceAdapter(final RestTemplate restTemplate,
                                             final ApplicationConfiguration appConfig) {
        super(restTemplate, appConfig);
        this.restTemplate = restTemplate;
        this.appConfig = appConfig;
    }

    public ResponseEntity<Clan> getClanData(final String clanTag) throws RestClientException {
        if (StringUtils.isEmpty(clanTag)) {
            throw new InvalidParameterException("Clan Tag cannot be empty.");
        }

        final String urlTemplate = buildUrlTemplate();

        return get(Clan.class, urlTemplate, getFormattedClanTag(clanTag));
    }

    private String buildUrlTemplate() {
        final UriComponents uriComponents = UriComponentsBuilder
                .newInstance()
                .scheme(HTTPS)
                .host(CR_API_BASE_URL)
                .path(CLAN_PATH_TEMPLATE)
                .build();

        return uriComponents
                .toUriString();
    }

    private String getFormattedClanTag(final String clanTag) {
        if (clanTag.indexOf(CLAN_TAG_PREFIX) == 0) {
            return clanTag;
        } else {
            return CLAN_TAG_PREFIX + clanTag;
        }
    }
}
