package br.com.capela.amicao.modelo.pet;

import br.com.capela.amicao.modelo.Enumv
import br.com.capela.persistencia.EnumvType

object SexoEnum extends Enumeration with Enumv{
	val indefinido = Value("Indefinido")
	val macho = Value("Macho")
	val femea = Value("Femea")
}

class SexoEnumType extends EnumvType(SexoEnum) {}