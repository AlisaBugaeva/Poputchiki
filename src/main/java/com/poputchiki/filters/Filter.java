package com.poputchiki.filters;

import com.poputchiki.RequestContext;
import com.poputchiki.constants.ApiConstants;
import com.poputchiki.repositories.UserTokenRepository;
import com.poputchiki.services.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class Filter implements javax.servlet.Filter {

    private AuthService authService;
    private RequestContext requestContext;
    private UserTokenRepository userTokenRepository;

    private Logger log = LoggerFactory.getLogger(Filter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException
    {
        boolean flag = false;

        log.info("path: "+ ((HttpServletRequest) servletRequest).getServletPath());

        for (int i = 0; i < ApiConstants.mas.length; i++) {
            if (((HttpServletRequest) servletRequest).getServletPath().contains(ApiConstants.mas[i])) {
                flag = true;
                if (authService.loginByToken(((HttpServletRequest) servletRequest).getHeader("token")) != null) {
                    requestContext.setToken(((HttpServletRequest) servletRequest).getHeader("token"));
                    requestContext.setUserId(userTokenRepository.findByAccessToken(((HttpServletRequest) servletRequest).getHeader("token")).getUserId());
                    filterChain.doFilter(servletRequest, servletResponse);

                }

            }
        }
        if (!flag){filterChain.doFilter(servletRequest, servletResponse);}


       // ((HttpServletRequest) servletRequest).getHeader("token");
        //((HttpServletRequest) servletRequest).getMethod(); -> POST/GET/...

        //filterChain.doFilter(servletRequest, servletResponse);

        //requestContext.setUserId();
    }
}
