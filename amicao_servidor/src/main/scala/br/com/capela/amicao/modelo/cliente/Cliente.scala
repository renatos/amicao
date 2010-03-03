package br.com.capela.amicao.modelo.cliente

;

import org.apache.commons.lang.builder.{EqualsBuilder, HashCodeBuilder, ReflectionToStringBuilder, ToStringStyle};

import br.com.capela.amicao.modelo.base.Entidade;
import br.com.capela.amicao.modelo.pet.Pet;



import javax.persistence._

import scala.reflect._

@Entity
class Cliente extends Entidade[Cliente] {
  @Column {val name = "codigo"}
  @BeanProperty var codigo: String = _

  @Column {val name = "nome"}
  @BeanProperty var nome: String = _

  @OneToOne {
  val cascade = Array(CascadeType.ALL),
  val targetEntity = classOf[Endereco]
  }
  @PrimaryKeyJoinColumn()
  @BeanProperty var endereco: Endereco = _

  @OneToOne {
  val cascade = Array(CascadeType.ALL),
  val targetEntity = classOf[FormaDeContato]
  }
  @PrimaryKeyJoinColumn()
  @BeanProperty var formaDeContato: FormaDeContato = _

  @OneToMany {
  val cascade = Array(CascadeType.ALL),
  val targetEntity = classOf[Pet],
  val mappedBy = "proprietario"
  }
  @BeanProperty var pets: java.util.List[Pet] = new java.util.Vector[Pet]

  def inserePet(pet: Pet): Unit = {
    if (!this.pets.contains(pet)) {
      println("inserindo: " + pet.nome + " " + pet.especie)
      this.pets.add(pet);
      pet.proprietario = this
    }
  }

  def removePet(pet: Pet): Unit = {
    if (this.pets.contains(pet)) {
      this.pets.remove(pet);
      pet.proprietario = null;
    }
  }

  def isMesmaEntidade(outro: Cliente): Boolean = {
    new EqualsBuilder()
            .append(nome, outro.nome)
            .append(endereco, outro.endereco)
            .isEquals();
  }

  override def hashCode(): Int = {
    new HashCodeBuilder()
            .append(nome)
            .append(endereco)
            .toHashCode();
  }

  override def toString() = ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE)
}

