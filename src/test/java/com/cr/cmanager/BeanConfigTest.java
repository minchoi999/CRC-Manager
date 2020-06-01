package com.cr.cmanager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BeanConfigTest {

    private BeanConfig beanConfig;

    @BeforeEach
    public void setup() {
        beanConfig = new BeanConfig();
    }

    @Test
    public void testRestTemplate() {
        assertTrue(beanConfig.restTemplate() instanceof RestTemplate);
    }
}
