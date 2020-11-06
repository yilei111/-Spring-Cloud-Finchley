package com.yi.servicezuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yilei
 * @version 1.0
 * @description TODO
 * @className MyFilter
 * @date 2020/9/28 9:24
 **/
@Component
public class LoginFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(LoginFilter.class);

    @Override
    public String filterType() {
        // 定义为前置过滤器
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        // 在处理请求头之前进行拦截
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        // 开启过滤器
        return true;
    }

    @Override
    public Object run() {
        // 获取请求上下文,此作用域范围:从请求到达zuul一直到路由结束后返回给客户端这个完整流程.但是它不会存在微服务内,只存在zuul中
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        //获取请求参数
        String accessToken = request.getParameter("token");
        //判断是否存在
        if (StringUtils.isBlank(accessToken)) {
            //不存在,未登录,进行拦截
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
        }
        return null;
    }
}
