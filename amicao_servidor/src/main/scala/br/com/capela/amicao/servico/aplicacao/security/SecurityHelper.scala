package br.com.capela.amicao.servico.aplicacao.security

import org.springframework.flex.security3.AuthenticationResultUtils
import org.springframework.flex.remoting.{RemotingInclude, RemotingDestination}
import org.springframework.stereotype.Component

/**
 * Created by IntelliJ IDEA.
 * User: renatos
 * Date: 15/02/2010
 * Time: 00:04:36
 * To change this template use File | Settings | File Templates.
 */

@Component
@RemotingDestination {val channels = Array("amf", "secure-amf")}
class SecurityHelper {
  @RemotingInclude
  def getAuthentication(): java.util.Map[String, Object] = AuthenticationResultUtils.getAuthenticationResult();

}