package com.cr.cmanager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;

import static com.cr.cmanager.ApplicationConfiguration.CLASH_ROYALE_API_KEY_ENV_KEY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ApplicationConfigurationTest {

    private static final String CLASH_ROYALE_API_KEY = "apiKey";

    @Mock
    private Environment env;
    @InjectMocks
    private ApplicationConfiguration applicationConfiguration;

    @Test
    public void testGetClashRoyaleApiKey() {
        when(env.getProperty(CLASH_ROYALE_API_KEY_ENV_KEY)).thenReturn(CLASH_ROYALE_API_KEY);

        assertEquals(CLASH_ROYALE_API_KEY, applicationConfiguration.getClashRoyaleApiKey());
    }

}
