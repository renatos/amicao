package br.com.capela.amicao.persistencia;

import br.com.capela.amicao.modelo.Enumv

import scala._
import java.io._
import java.sql.{ResultSet, PreparedStatement, Types}
import javax.persistence._
import org.hibernate.usertype.UserType

abstract class EnumvType(val et: Enumeration with Enumv)
   extends UserType {

   val SQL_TYPES = Array({Types.VARCHAR})

   override def sqlTypes() = SQL_TYPES

   override def returnedClass = classOf[et.Value]

   override def equals(x: Object, y: Object): Boolean = {
     return x == y
   }

   override def hashCode(x: Object) = x.hashCode

   override def nullSafeGet(resultSet: ResultSet,
                            names: Array[String],
                            owner: Object): Object = {
     val value = resultSet.getString(names(0))
     if (resultSet.wasNull()) return null
     else {
       return et.valueOf(value).getOrElse(null)
     }
   }

   override def nullSafeSet(statement: PreparedStatement,
                            value: Object,
                            index: Int): Unit = {
     if (value == null) {
       statement.setNull(index, Types.VARCHAR)
     } else {
       val en = value.toString
       statement.setString(index, en)
     }
   }

   override def deepCopy(value: Object): Object = value

   override def isMutable() = false

   override def disassemble(value: Object) =
     value.asInstanceOf[Serializable]

   override def assemble(cached: Serializable, owner: Object):
     Serializable = cached

   override def replace(original: Object,
                        target: Object,
                        owner: Object) = original

}

