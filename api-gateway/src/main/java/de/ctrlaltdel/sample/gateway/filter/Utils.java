package de.ctrlaltdel.sample.gateway.filter;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SEND_ERROR_FILTER_ORDER;

import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import com.netflix.zuul.context.RequestContext;

import org.keycloak.KeycloakPrincipal;

public interface Utils {

    public static final String AUTHORIZATION = "Authorization";

    public static final int FILTER_ORDER = SEND_ERROR_FILTER_ORDER;

    public static boolean shouldFilter() {
        return Utils.getUserPrincipal() instanceof KeycloakPrincipal;
    }

    public static HttpServletResponse getResponse() {
        return RequestContext.getCurrentContext().getResponse();
    }

    public static String extractBearer() {
        return String.format("Bearer %s", extractToken());
    }

    public static String extractToken() {
        Principal principal = getUserPrincipal();
        return principal instanceof KeycloakPrincipal
                ? ((KeycloakPrincipal) principal).getKeycloakSecurityContext().getTokenString()
                : "";
    }

    public static Principal getUserPrincipal() {
        RequestContext context = RequestContext.getCurrentContext();
        Principal principal = context.getRequest().getUserPrincipal();
        return principal != null ? principal : (Principal) context.get(Principal.class.getName());
    }
}
