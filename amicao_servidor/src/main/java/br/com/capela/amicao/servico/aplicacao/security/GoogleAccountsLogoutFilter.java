package br.com.capela.amicao.servico.aplicacao.security;

import com.google.appengine.api.users.UserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: renatos
 * Date: 18/02/2010
 * Time: 00:14:21
 * To change this template use File | Settings | File Templates.
 */
public class GoogleAccountsLogoutFilter extends LogoutFilter implements InitializingBean {

    private List<LogoutHandler> handlers;
    private String afterLogoutUrl = "/";
    private UserService userService;

    public GoogleAccountsLogoutFilter(String logoutSuccessUrl, LogoutHandler... handlers) {
        super(logoutSuccessUrl, handlers);
        this.handlers = Arrays.asList(handlers);
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        if (requiresLogout(httpRequest, httpResponse)) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();

            System.out.println("Logging out user '" + auth + "' and transferring to logout destination");

            for (LogoutHandler handler : handlers) {
                handler.logout(httpRequest, httpResponse, auth);
            }

            // redirect to logout page
            String googleAccountsLogoutURL = this.userService.createLogoutURL(getAfterLogoutUrl());
            httpResponse.sendRedirect(googleAccountsLogoutURL);

            return;
        }

        chain.doFilter(request, response);
    }

    /**
     * Allow subclasses to modify when a logout should take place.
     *
     * @param request  the request
     * @param response the response
     * @return <code>true</code> if logout should occur, <code>false</code> otherwise
     */
    protected boolean requiresLogout(HttpServletRequest request, HttpServletResponse response) {
        String uri = request.getRequestURI();
        int pathParamIndex = uri.indexOf(';');

        if (pathParamIndex > 0) {
            // strip everything from the first semi-colon
            uri = uri.substring(0, pathParamIndex);
        }

        int queryParamIndex = uri.indexOf('?');

        if (queryParamIndex > 0) {
            // strip everything from the first question mark
            uri = uri.substring(0, queryParamIndex);
        }

        if ("".equals(request.getContextPath())) {
            return uri.endsWith(super.getFilterProcessesUrl());
        }

        return uri.endsWith(request.getContextPath() + super.getFilterProcessesUrl());
    }

    public void setAfterLogoutUrl(String afterLogoutUrl) {
        this.afterLogoutUrl = afterLogoutUrl;
    }

    public String getAfterLogoutUrl() {
		return afterLogoutUrl;
	}

}

