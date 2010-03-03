package br.com.capela.amicao.modelo.cliente

;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import br.com.capela.amicao.modelo.base.Entidade;




import javax.persistence._



import scala.reflect._

@Entity
class FormaDeContato extends Entidade[FormaDeContato] {
  @Column {val name = "telefone1"}
  @BeanProperty var telefone1: String = _

  @Column {val name = "telefone2"}
  @BeanProperty var telefone2: String = _

  @Column {val name = "celular"}
  @BeanProperty var celular: String = _

  @Column {val name = "email"}
  @BeanProperty var email: String = _

  override def hashCode(): Int = {
    return new HashCodeBuilder().append(telefone1).append(celular).append(email).toHashCode();
  }

  def isMesmaEntidade(outro: FormaDeContato): Boolean = {
    new EqualsBuilder()
            .append(telefone1, outro.telefone1)
            .append(celular, outro.celular)
            .append(email, outro.email)
            .isEquals();
  }

}
