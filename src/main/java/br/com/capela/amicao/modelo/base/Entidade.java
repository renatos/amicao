package br.com.capela.amicao.modelo.base;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Entidade<T> {

	@Id
	@org.hibernate.annotations.GenericGenerator(name = "hibernate-uuid", strategy = "uuid")
	@GeneratedValue(generator = "hibernate-uuid")
	protected Long id;

	public Long getId() {
		return id;
	}

	public abstract Boolean isMesmaEntidade(T outraEntidade);

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Entidade<?>)) {
			return false;
		}
		T outro = (T) obj;
		return isMesmaEntidade(outro);
	}

}
