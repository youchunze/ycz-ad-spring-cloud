package com.ycz.ad.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: hyczzz
 * @date: 2019/12/8 0008 21:22
 * @description:
 */
@Slf4j
@Component
public class AccessLogFilter extends ZuulFilter{
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext ctx  = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        Long startTime = (Long) ctx.get("startTime");
        String  uri = request.getRequestURI();
        Long duration = System.currentTimeMillis() - startTime;

        log.info("uri: {},duration: {}ms",uri,duration / 100);

        return null;
    }
}
