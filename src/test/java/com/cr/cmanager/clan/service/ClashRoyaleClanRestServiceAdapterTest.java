package com.cr.cmanager.clan.service;

import com.cr.cmanager.ApplicationConfiguration;
import com.cr.cmanager.framework.exception.InvalidRequestException;
import com.cr.cmanager.framework.model.Clan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClashRoyaleClanRestServiceAdapterTest {

    private static final String CLAN_TAG = "clanTag";
    private static final String FORMATTED_CLAN_TAG = "#clanTag";

    @Mock
    private RestTemplate restTemplate;
    @Mock
    private ApplicationConfiguration appConfig;
    @Mock
    private ResponseEntity<Clan> response;
    @Mock
    private Clan clan;

    private ClashRoyaleClanRestServiceAdapter adapter;

    @BeforeEach
    public void setup() {
        adapter = new ClashRoyaleClanRestServiceAdapter(restTemplate, appConfig);
    }

    @Test
    public void testCallWithInvalidClanTag() {
        assertThrows(InvalidRequestException.class, () -> {
            adapter.call(null);
        });
    }

    @Test
    public void testCallWithFormattedClanTag() throws Exception {
        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(HttpEntity.class), eq(Clan.class), eq(FORMATTED_CLAN_TAG)))
                .thenReturn(response);
        when(response.getBody()).thenReturn(clan);

        final Clan actualResponseClan = adapter.call(FORMATTED_CLAN_TAG);

        assertEquals(clan, actualResponseClan);
    }

    @Test
    public void testCallWithUnformattedClanTag() throws Exception {
        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(HttpEntity.class), eq(Clan.class), eq(FORMATTED_CLAN_TAG)))
                .thenReturn(response);
        when(response.getBody()).thenReturn(clan);

        final Clan actualResponseClan = adapter.call(CLAN_TAG);

        assertEquals(clan, actualResponseClan);
    }
}
