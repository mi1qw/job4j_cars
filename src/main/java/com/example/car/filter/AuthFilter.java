
package com.example.car.filter;


import com.example.car.web.UserSession;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class AuthFilter implements Filter {
    @Override
    public void doFilter(
            final ServletRequest request,
            final ServletResponse response,
            final FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        if (uri.equals("/")
                || uri.startsWith("/css")
                || uri.startsWith("/js")
                || uri.startsWith("/images")
                || uri.startsWith("/posts")
                || uri.startsWith("/cars/img")
                || uri.startsWith("/cars/models")
                || uri.endsWith("logIn")
                || uri.endsWith("signPage")
                || uri.endsWith("signIn")
                || uri.startsWith("/posts/ex")) {
            chain.doFilter(req, res);
            return;
        }
        UserSession userSession = (UserSession) req.getSession()
                .getAttribute("scopedTarget.userSession");
        if (userSession == null || userSession.getAccount() == null) {
            res.sendRedirect(req.getContextPath() + "/");
            return;
        }
        chain.doFilter(req, res);
    }
}

