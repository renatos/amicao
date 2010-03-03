package br.com.capela.amicao.servico.aplicacao.security

import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter
import javax.servlet.http.HttpServletRequest
import _root_.com.google.appengine.api.users.{User, UserService}
/**
 * Created by IntelliJ IDEA.
 * User: renatos
 * Date: 17/02/2010
 * Time: 01:07:10
 * To change this template use File | Settings | File Templates.
 */

class GoogleAccountsAuthenticationProcessingFilter extends AbstractPreAuthenticatedProcessingFilter {
  var userService: UserService = null

  def setUserService(userService: UserService) = this.userService = userService

  override protected def getPreAuthenticatedCredentials(request: HttpServletRequest): Object = {
    println("GoogleAccountsAuthenticationProcessingFilter getPreAuthenticatedCredentials ")
    return "N/A";
  }

  override protected def getPreAuthenticatedPrincipal(request: HttpServletRequest): Object = {
    val user: User = userService.getCurrentUser();
    println("GoogleAccountsAuthenticationProcessingFilter getPreAuthenticatedPrincipal user: " + user)
    if (user != null)
      println(user.getEmail());
    return user;
  }

  def getOrder(): Integer = {
    return 0;
  }

}