package cc.databus.pkg

import scala.collection.immutable._

/**
  * Created by yuange.zjy on 2019/1/27.
  */
object TypeRename {
  def main(args: Array[String]): Unit = {
    import java.util.{HashMap => JavaHashMap, ArrayList => _}


    val javaHashMap = new JavaHashMap[String, String]()
    javaHashMap.put("Hello", "World")
    val scalaMap = HashMap("Hello" -> "World", "Chengdu" -> "China")


    println(javaHashMap)
    println(scalaMap)
  }
}
