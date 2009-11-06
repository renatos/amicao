package br.com.capela.amicao.modelo.pet;

import br.com.capela.amicao.modelo.Enumv
import br.com.capela.amicao.persistencia.EnumvType

object EspecieEnum extends Enumeration with Enumv{
	val indefinida = Value("Indefinida")
	val canina = Value("Canina")
	val felina = Value("Felina")
}

class EspecieEnumType extends EnumvType(EspecieEnum) {}
