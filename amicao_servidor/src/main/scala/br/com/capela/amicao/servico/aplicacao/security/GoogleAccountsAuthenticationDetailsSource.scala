package br.com.capela.amicao.servico.aplicacao.security

import org.springframework.security.authentication.AuthenticationDetailsSourceImpl
import org.springframework.security.web.authentication.preauth.PreAuthenticatedGrantedAuthoritiesAuthenticationDetails
import _root_.com.google.appengine.api.users.UserService
import org.springframework.security.core.authority.{GrantedAuthorityImpl, MutableGrantedAuthoritiesContainer}
import java.util.Arrays

/**
 * Created by IntelliJ IDEA.
 * User: renatos
 * Date: 17/02/2010
 * Time: 23:03:46
 * To change this template use File | Settings | File Templates.
 */

class GoogleAccountsAuthenticationDetailsSource extends AuthenticationDetailsSourceImpl {
  super.setClazz(classOf[PreAuthenticatedGrantedAuthoritiesAuthenticationDetails])

  private var userService: UserService = null

  def setUserService(userService: UserService) = this.userService = userService

  override def buildDetails(context: Object): Object = {

    val result = super.buildDetails(context);

    println("GoogleAccountsAuthenticationDetailsSource: " + result)

    result match {
      case result: MutableGrantedAuthoritiesContainer => {
        val mac: MutableGrantedAuthoritiesContainer = result.asInstanceOf[MutableGrantedAuthoritiesContainer];
        if (userService.isUserAdmin()) {
          mac.setGrantedAuthorities(Arrays.asList(
            new GrantedAuthorityImpl("ROLE_GOOGLE_APP_ADMIN"),
            new GrantedAuthorityImpl("ROLE_GOOGLE_APP_USER"),
            new GrantedAuthorityImpl("GOOGLE_AUTH_DOMAIN_" + userService.getCurrentUser()
                    .getAuthDomain())));
        } else if (userService.isUserLoggedIn()) {
          mac.setGrantedAuthorities(Arrays.asList(
            new GrantedAuthorityImpl("ROLE_GOOGLE_APP_USER"),
            new GrantedAuthorityImpl("GOOGLE_AUTH_DOMAIN_" + userService.getCurrentUser()
                    .getAuthDomain())));
        }
      }
    }
    return result;
  }
}
