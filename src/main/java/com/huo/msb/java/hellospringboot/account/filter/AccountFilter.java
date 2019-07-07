package com.huo.msb.java.hellospringboot.account.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author huoyun
 * @date 2019/7/2-21:49
 */
@Component
@WebFilter
public class AccountFilter implements Filter {

    private final static String[] INGORE_URIS = {"/js","/css","/account/index", "/account/login", "/favicon.ico","/api/account/login"};

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String uri = request.getRequestURI();
        System.out.println("uri:" + uri);
        // 是否是公开uri
        boolean b = canPass(uri);
        if (b) {
            filterChain.doFilter(request, response);
        } else {
            // 校验session  是否登录
            Object account = request.getSession().getAttribute("account");
            if (null == account) {
                // 重定向回登录页
                response.sendRedirect("/account/login");
            } else {
                filterChain.doFilter(request, response);
            }
        }

    }

    /**
     * @param uri 校验的uri
     * @return 是否放行
     */
    private boolean canPass(String uri) {
        for (String tmp : INGORE_URIS) {
            if (uri.startsWith(tmp)) {
                return true;
            }
        }
        return false;
    }
}
