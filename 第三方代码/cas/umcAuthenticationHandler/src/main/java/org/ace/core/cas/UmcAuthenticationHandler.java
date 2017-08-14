package org.ace.core.cas;

import org.apereo.cas.authentication.HandlerResult;
import org.apereo.cas.authentication.PreventedException;
import org.apereo.cas.authentication.UsernamePasswordCredential;
import org.apereo.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.apereo.cas.authentication.principal.PrincipalFactory;
import org.apereo.cas.services.ServicesManager;

import javax.security.auth.login.FailedLoginException;
import java.security.GeneralSecurityException;

/**
 * Created by doraemon on 7/15/2017.
 * 这是一个向umc认证api提交用户名密码的cas扩展认证处理器
 */
public class UmcAuthenticationHandler extends AbstractUsernamePasswordAuthenticationHandler {

    public UmcAuthenticationHandler(String name, ServicesManager servicesManager, PrincipalFactory principalFactory, Integer order) {
        super(name, servicesManager, principalFactory, order);
    }

    @Override
    protected HandlerResult authenticateUsernamePasswordInternal(UsernamePasswordCredential transformedCredential, String originalPassword) throws GeneralSecurityException, PreventedException {
        String username = transformedCredential.getUsername();
        if (username.equals("test"))
            return createHandlerResult(transformedCredential, this.principalFactory.createPrincipal(username), null);
        throw new FailedLoginException();
    }
}
