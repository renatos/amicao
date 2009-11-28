package br.com.capela.amicao.persistencia;

import br.com.capela.amicao.modelo.Enumv

import scala._
import java.io._
import java.sql.{ResultSet, PreparedStatement, Types}
import javax.persistence._

abstract class EnumvType(val et: Enumeration with Enumv)
   {

   val SQL_TYPES = Array({Types.VARCHAR})

   def sqlTypes() = SQL_TYPES

   def returnedClass = classOf[et.Value]

   def equals(x: Object, y: Object): Boolean = {
     return x == y
   }

   def hashCode(x: Object) = x.hashCode

   def nullSafeGet(resultSet: ResultSet,
                            names: Array[String],
                            owner: Object): Object = {
     val value = resultSet.getString(names(0))
     if (resultSet.wasNull()) return null
     else {
       return et.valueOf(value).getOrElse(null)
     }
   }

   def nullSafeSet(statement: PreparedStatement,
                            value: Object,
                            index: Int): Unit = {
     if (value == null) {
       statement.setNull(index, Types.VARCHAR)
     } else {
       val en = value.toString
       statement.setString(index, en)
     }
   }

   def deepCopy(value: Object): Object = value

   def isMutable() = false

   def disassemble(value: Object) =
     value.asInstanceOf[Serializable]

   def assemble(cached: Serializable, owner: Object):
     Serializable = cached

   def replace(original: Object,
                        target: Object,
                        owner: Object) = original

}

