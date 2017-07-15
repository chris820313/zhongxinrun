package org.ace.core.conf.cas;

import org.ace.core.cas.UmcAuthenticationHandler;
import org.apereo.cas.authentication.AuthenticationEventExecutionPlan;
import org.apereo.cas.authentication.AuthenticationEventExecutionPlanConfigurer;
import org.apereo.cas.authentication.AuthenticationHandler;
import org.apereo.cas.authentication.principal.DefaultPrincipalFactory;
import org.apereo.cas.authentication.principal.PrincipalFactory;
import org.apereo.cas.services.ServicesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by doraemon on 7/15/2017.
 */
@Configuration("umcAuthenticationEventExecutionPlanConfiguration")
public class UmcAuthenticationEventExecutionPlanConfiguration implements AuthenticationEventExecutionPlanConfigurer {
    @Autowired
    @Qualifier("servicesManager")
    private ServicesManager servicesManager;

    @ConditionalOnMissingBean(name = "umcPrincipalFactory")
    @Bean
    public PrincipalFactory umcPrincipalFactory() {
        return new DefaultPrincipalFactory();
    }

    /**
     * 生成认证处理器的Bean
     *
     * @return
     */
    @RefreshScope
    @Bean
    public AuthenticationHandler umcAuthenticationHandler() {
        UmcAuthenticationHandler handler = new UmcAuthenticationHandler("", servicesManager, umcPrincipalFactory(), null);
        return handler;
    }

    /**
     * 注册认证处理器
     *
     * @param plan
     */
    @Override
    public void configureAuthenticationExecutionPlan(AuthenticationEventExecutionPlan plan) {
        plan.registerAuthenticationHandler(umcAuthenticationHandler());
    }
}
