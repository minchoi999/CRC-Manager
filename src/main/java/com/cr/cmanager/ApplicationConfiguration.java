package com.cr.cmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value="classpath:application.properties")
public class ApplicationConfiguration {

    @Autowired
    private Environment env;

    public String getClashRoyaleApiBaseUrl() {
        return env.getProperty("clash.royale.api.base.url");
    }

    public String getClashRoyaleApiKey() {
        return env.getProperty("clash.royale.api.key");
    }
}
