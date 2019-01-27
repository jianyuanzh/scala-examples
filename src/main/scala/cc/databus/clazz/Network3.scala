package cc.databus.clazz

import scala.collection.mutable.ArrayBuffer

/**
  * Created by yuange.zjy on 2019/1/27.
  */
class Network3 {

  val members = new ArrayBuffer[Member]() // 使用类型投影

  class Member(name: String) {
    val contacts = new ArrayBuffer[Network3#Member]()
  }

  def join(name: String): Member = {
    val m = new Member(name)
    members += m
    m
  }
}

object Network3 {
  def main(args: Array[String]): Unit = {
    val jianyuan = new Network3
    val defang = new Network3

    val fred = jianyuan.join("Fred")
    val vincent = defang.join("Vincent")

    fred.contacts += vincent // 这是允许的，因为contacts使用的类型投影Network3#Member的方式，表示任何对象的Member
  }
}
