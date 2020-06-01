package com.cr.cmanager;

import com.google.common.annotations.VisibleForTesting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value="classpath:application.properties")
public class ApplicationConfiguration {

    @VisibleForTesting
    static final String CLASH_ROYALE_API_KEY_ENV_KEY = "clash.royale.api.key";

    @Autowired
    private Environment env;

    public String getClashRoyaleApiKey() {
        return env.getProperty(CLASH_ROYALE_API_KEY_ENV_KEY);
    }
}
