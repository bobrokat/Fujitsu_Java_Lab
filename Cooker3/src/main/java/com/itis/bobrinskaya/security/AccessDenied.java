package com.itis.bobrinskaya.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ekaterina on 26.04.2016.
 */
public class AccessDenied implements AccessDeniedHandler {

    private String errorPage;

    public AccessDenied() {
    }

    /**
     *
     * @param errorPage
     * creates AccessDenied object with parameter
     */
    public  AccessDenied(String errorPage) {
        this.errorPage = errorPage;
    }

    /**
     *
     * @return errorpage
     */

    public String getErrorPage() {
        return errorPage;
    }

    /**
     *
     * @param errorPage
     * changes errorpage to selected one
     */
    public void setErrorPage(String errorPage) {
        this.errorPage = errorPage;
    }

    /**
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param e
     * @throws IOException
     * @throws ServletException
     * makes redirect to errorpage
     */
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.sendRedirect("/403");
    }
}
