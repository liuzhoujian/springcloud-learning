package com.lzj.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class MyFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        String token = request.getParameter("token");

        //为空，返回错误信息
        if(token == null) {
          context.setSendZuulResponse(false);
          context.setResponseStatusCode(401);
            try {
                context.getResponse().getWriter().write("token is empty！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //不为空，放行
        return null;
    }
}
