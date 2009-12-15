package br.com.capela.amicao.modelo.pet;

import org.apache.commons.lang.builder.{EqualsBuilder, HashCodeBuilder, ReflectionToStringBuilder, ToStringStyle};

import java.util.List;

import br.com.capela.amicao.modelo.base.Entidade

import java.io.Serializable;
import java.util.Date

import javax.persistence._

import scala.reflect._

import _root_.com.google.appengine.api.datastore.Key;

import br.com.capela.amicao.modelo.cliente.Cliente;
import br.com.capela.amicao.modelo.servico.Servico;

@Entity
class Pet extends Entidade[Pet]{

    @Column{val name="codigo"}
    @BeanProperty var codigo:String = _

    @Column{val name="nome"}
    @BeanProperty var nome:String = _

    @Temporal(TemporalType.DATE)
    @Column{val name="dataDeNascimento"}
    @BeanProperty var dataDeNascimento:Date = _
	
    @ManyToOne{
    	val cascade = Array(CascadeType.PERSIST),
        val targetEntity = classOf[Cliente]
    }
    @BeanProperty var proprietario : Cliente = _

    @ManyToOne{
    	val cascade = Array(CascadeType.PERSIST),
        val targetEntity = classOf[Raca]
    }
    @BeanProperty var raca: Raca = _

    @OneToMany{
    	val cascade = Array(CascadeType.PERSIST),
        val targetEntity = classOf[Cor]
    }
    @BeanProperty var coresPredominantesDoPelo: java.util.List[Cor] = new java.util.Vector[Cor]
    
    @Column{val name="especie"}
    private var _especie : String = EspecieEnum.indefinida.toString
    
    @Column{val name="sexo"}
    private var _sexo: String = SexoEnum.indefinido.toString
    
    def especie(especie: EspecieEnum.Value):Unit = this._especie = especie.toString
    
    def especie = 
      this._especie match {
        case null => EspecieEnum.indefinida
        case _ 	  => EspecieEnum.valueOf(this._especie).getOrElse(EspecieEnum.indefinida)
      }

    def sexo(sexo: SexoEnum.Value):Unit = this._sexo = sexo.toString
    
    def sexo = 
    	this._sexo match {
    	case null => SexoEnum.indefinido
    	case _ 	  => SexoEnum.valueOf(this._sexo).getOrElse(SexoEnum.indefinido.toString)
    }

    //private List<Servico> servicosPrestados;
    
    
/*    
    def insereProprietario(proprietario:Cliente):Unit = {
    	if(!this.proprietarios.contains(proprietario)){
    	   this.proprietarios.add(proprietario);
    	   proprietario.inserePet(this);		
    	}
    }
    
    def removeProprietario(proprietario:Cliente):Unit = {
    	if(this.proprietarios.contains(proprietario)){
    	   this.proprietarios.remove(proprietario);
    	   proprietario.removePet(this);		
    	}
    }
*/    
    def isMesmaEntidade(outro:Pet):Boolean =  {
      new EqualsBuilder()
        .append(nome, outro.nome)
        .append(codigo, outro.codigo)
        .append(dataDeNascimento, outro.dataDeNascimento)
        .isEquals();
    }

    override def hashCode():Int = {
        new HashCodeBuilder()
        .append(nome)
        .append(codigo)
        .append(dataDeNascimento)
        .toHashCode();
    }
    
    override def toString() = ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE)
}

