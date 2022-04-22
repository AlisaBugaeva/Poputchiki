package com.poputchiki.filters;

import com.poputchiki.RequestContext;
import com.poputchiki.constants.ApiConstants;
import com.poputchiki.repositories.UserTokenRepository;
import com.poputchiki.services.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class Filter implements javax.servlet.Filter {

    private AuthService authService;
    private RequestContext requestContext;

    public Filter(AuthService authService, RequestContext requestContext) {
        this.authService = authService;
        this.requestContext = requestContext;
    }

    private Logger log = LoggerFactory.getLogger(Filter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException
    {
        HttpServletRequest castServletRequest = (HttpServletRequest) servletRequest;

        log.info("path: "+ castServletRequest.getServletPath());



            if (ifSecuredPath(castServletRequest)) {
                if (authService.loginByToken(castServletRequest.getHeader("token")) != null) {
                    requestContext.setToken(castServletRequest.getHeader("token"));
                    requestContext.setUserId(authService.loginByToken(castServletRequest.getHeader("token")).getUserId());
                    filterChain.doFilter(servletRequest, servletResponse);
                }
                else{((HttpServletResponse)servletResponse).setStatus(HttpStatus.UNAUTHORIZED.value());}
        }
        else {filterChain.doFilter(servletRequest, servletResponse);}
    }

    public boolean ifSecuredPath(HttpServletRequest castServletRequest){
        for (int i = 0; i < ApiConstants.securedPaths.length; i++) {
            if (castServletRequest.getServletPath().contains(ApiConstants.securedPaths[i])) {
                return true;
            }
        }
        return false;
    }
}
