package de.ctrlaltdel.sample.gateway.filter;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;

import com.netflix.zuul.ZuulFilter;

public abstract class ZuulPostFilter extends ZuulFilter {
    
    @Override
    public final String filterType() {
        return POST_TYPE;
    }

}
