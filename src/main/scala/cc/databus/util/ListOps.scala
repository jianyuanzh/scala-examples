package cc.databus.util

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

class ListOps(x: Int, t: String) {
  val seq: Int = x
  val typeName: String = t
  override def toString: String = "Seq: " + x + "@" + typeName
  def split(): List[ListOps] = {
    (0 to seq).map(i => new ListOps(i, typeName)).toList
  }
}

object ListOps extends App {

  val groupMap: mutable.Map[String /*groupName*/ , ListBuffer[ListOps]] = mutable.Map.empty
  val singleDpList: ListBuffer[ListOps] = mutable.ListBuffer.empty


  println()

}
