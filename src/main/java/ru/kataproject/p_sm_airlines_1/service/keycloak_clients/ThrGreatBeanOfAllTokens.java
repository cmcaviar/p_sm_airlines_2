package ru.kataproject.p_sm_airlines_1.service.keycloak_clients;

import org.keycloak.adapters.springsecurity.account.SimpleKeycloakAccount;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * class that provides a method to get all available tokens in String format,
 * does not authenticate, however all the tokens can be used in production
 */
@Component
public class ThrGreatBeanOfAllTokens {

    @Bean
    @Scope(scopeName = WebApplicationContext.SCOPE_REQUEST,
            proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Map<String,String> getTokens() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        KeycloakAuthenticationToken userPrincipal = (KeycloakAuthenticationToken) request.getUserPrincipal();
        SimpleKeycloakAccount userPrincipalDetails = (SimpleKeycloakAccount) userPrincipal.getDetails();
        Map<String,String> tokens=new HashMap<>();
        tokens.put("refresh_token",userPrincipalDetails
                .getKeycloakSecurityContext().getRefreshToken());
        tokens.put("access_token",userPrincipalDetails
                .getKeycloakSecurityContext().getTokenString());
        tokens.put("id_token",userPrincipalDetails
                .getKeycloakSecurityContext().getIdTokenString());
        tokens.put("access_token_expires_in", String.valueOf(userPrincipalDetails.getKeycloakSecurityContext().getToken().getExpiration()));
        return tokens;
    }
}
