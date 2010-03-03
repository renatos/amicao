package br.com.capela.amicao.servico.aplicacao

import org.springframework.stereotype.Service

import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.remoting.RemotingInclude;

@Service
@RemotingDestination {val channels = Array("amf")}
class TesteDeConexaoService {
  @RemotingInclude
  def getHoraAtual(): java.util.Date = new java.util.Date();

}
