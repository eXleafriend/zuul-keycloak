package de.ctrlaltdel.sample.gateway.filter;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

import com.netflix.zuul.ZuulFilter;

public abstract class ZuulPreFilter extends ZuulFilter {
    
    @Override
    public final String filterType() {
        return PRE_TYPE;
    }

}
