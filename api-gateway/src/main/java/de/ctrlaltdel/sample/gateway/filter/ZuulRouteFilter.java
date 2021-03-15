package de.ctrlaltdel.sample.gateway.filter;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.ROUTE_TYPE;

import com.netflix.zuul.ZuulFilter;

public abstract class ZuulRouteFilter extends ZuulFilter {
    
    @Override
    public final String filterType() {
        return ROUTE_TYPE;
    }

}
