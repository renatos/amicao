package br.com.capela.amicao.modelo

trait Enumv {
  this: Enumeration =>

  private var nameDescriptionMap =
  scala.collection.mutable.Map[String, String]()

  def Value(name: String, desc: String): Value = {
    nameDescriptionMap += (name -> desc)
    new Val(name)
  }

  def getDescriptionOrName(ev: this.Value) = {
    try {
      nameDescriptionMap("" + ev)
    } catch {
      case e: NoSuchElementException => ev.toString
    }
  }

  def getNameDescriptionList = this.elements.toList.map(
    v => (v.toString, getDescriptionOrName(v))).toList
}
