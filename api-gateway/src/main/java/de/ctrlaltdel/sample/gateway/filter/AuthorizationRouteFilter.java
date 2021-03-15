package de.ctrlaltdel.sample.gateway.filter;

import com.netflix.zuul.context.RequestContext;

import org.springframework.stereotype.Component;

/**
 * AuthorizationRouteFilter
 */
@Component
public class AuthorizationRouteFilter extends ZuulRouteFilter {

    @Override
    public int filterOrder() {
        return Utils.FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return Utils.shouldFilter();
    }

    @Override
    public Object run() {
        RequestContext.getCurrentContext().addZuulRequestHeader(Utils.AUTHORIZATION, Utils.extractBearer());
        return null;
    }

}
