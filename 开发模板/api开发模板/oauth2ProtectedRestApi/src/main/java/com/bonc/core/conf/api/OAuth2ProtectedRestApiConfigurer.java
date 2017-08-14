package com.bonc.core.conf.api;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

/**
 * Created by doraemon on 8/9/2017.
 */
@Configuration
public class OAuth2ProtectedRestApiConfigurer {
    @Bean
    @ConfigurationProperties("oauth2.check")
    public ResourceServerTokenServices httpTokenService() {
        return new RemoteTokenServices();
    }
}
