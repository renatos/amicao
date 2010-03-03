package br.com.capela.amicao.servico.aplicacao.security

import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.security.core.AuthenticationException
import javax.servlet.http.{HttpServletResponse, HttpServletRequest}
import _root_.com.google.appengine.api.users.UserService

/**
 * Created by IntelliJ IDEA.
 * User: renatos
 * Date: 17/02/2010
 * Time: 22:35:15
 * To change this template use File | Settings | File Templates.
 */

class GoogleLoginAuthenticationEntryPoint extends AuthenticationEntryPoint {
  var userService: UserService = null

  def setUserService(userService: UserService) = this.userService = userService

  def commence(request: HttpServletRequest, response: HttpServletResponse, authException: AuthenticationException) = {

    val thisURL = request.getRequestURI();
    println("GoogleLoginAuthenticationEntryPoint: " + thisURL)
    val thisURLEncoded = response.encodeRedirectURL(thisURL);
    println("GoogleLoginAuthenticationEntryPoint: " + thisURLEncoded)
    val loginPageRedirectURL = userService.createLoginURL(thisURLEncoded);

    println("Google Accounts login disparado pela chamada para GoogleLoginAuthenticationEntryPoint. Sending redirect to login page at " + loginPageRedirectURL);

    response.sendRedirect(loginPageRedirectURL);
  }

}