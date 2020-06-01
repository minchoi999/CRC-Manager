package com.cr.cmanager.clan.controller;

import com.cr.cmanager.clan.service.ClashRoyaleClanRestServiceAdapter;
import com.cr.cmanager.framework.exception.InvalidRequestException;
import com.cr.cmanager.framework.model.Clan;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClanControllerTest {

    private static final String CLAN_TAG = "clanTag";
    private static final String CLAN_TO_STRING = "clan";

    @InjectMocks
    private ClanController clanController;
    @Mock
    private ClashRoyaleClanRestServiceAdapter adapter;
    @Mock
    private Clan adapterResponse;

    @Test
    public void testIndexThrowsException() throws Exception {
        when(adapter.call(CLAN_TAG)).thenThrow(InvalidRequestException.class);

        assertThrows(InvalidRequestException.class, () -> {
            clanController.index(CLAN_TAG);
        });
    }

    @Test
    public void testIndex() throws Exception {
        when(adapter.call(CLAN_TAG)).thenReturn(adapterResponse);
        when(adapterResponse.toString()).thenReturn(CLAN_TO_STRING);

        final String actualResponse = clanController.index(CLAN_TAG);

        assertEquals(CLAN_TO_STRING, actualResponse);
    }
}
