package de.ctrlaltdel.sample.gateway.filter;

import org.springframework.stereotype.Component;

/**
 * BearerPostFilter
 * Returns the bearer to the client as Authorization-Header
 */
@Component
public class BearerPostFilter extends ZuulPostFilter {

    @Override
    public int filterOrder() {
        return Utils.FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return Utils.shouldFilter() && !Utils.getResponse().containsHeader(Utils.AUTHORIZATION);
    }

    @Override
    public Object run() {
        Utils.getResponse().addHeader(Utils.AUTHORIZATION, Utils.extractBearer());
        return null;
    }
}
